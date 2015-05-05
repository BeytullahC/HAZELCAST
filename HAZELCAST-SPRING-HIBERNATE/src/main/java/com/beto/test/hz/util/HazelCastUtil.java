package com.beto.test.hz.util;

import com.beto.test.hz.enums.EnHazelCast;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 912867 on 28.04.2015.
 */

public class HazelCastUtil<T> implements Serializable {

    private static Config cfg = new Config();
    private static ClientConfig clientConfig = new ClientConfig();
    private static HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
    ;
    private static HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);


    /**
     * @param en    Which Queue?
     * @param value
     * @throws InterruptedException
     */
    public void addDataToQueue(EnHazelCast en, T value) throws InterruptedException {
        BlockingQueue<T> queue = client.getQueue(String.valueOf(en));
        queue.put(value);
    }

    /**
     * @param en    Which Map?
     * @param key
     * @param value
     */

    public void addDataToMap(EnHazelCast en, Object key, T value) {
        Map<Object, T> map = instance.getMap(String.valueOf(en));
        map.clear();
        map.put(key, value);
    }

    /**
     * @param en Which Map?
     * @return Map<Object,T> from Hazelcast
     */
    public Map<Object, T> getDataToMap(EnHazelCast en) {
        return client.getMap(String.valueOf(en));
    }

    /**
     * Retrieves and removes the head of this queue
     *
     * @param en Which queue?
     * @return T from Hazelcast.
     */
    public T getDataToQueue(EnHazelCast en) {
        BlockingQueue<T> queue = client.getQueue(String.valueOf(en));
        return queue.poll();
    }

}
