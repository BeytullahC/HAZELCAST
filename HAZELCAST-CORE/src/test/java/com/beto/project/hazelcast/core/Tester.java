/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.project.hazelcast.core;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author 912867
 */
public class Tester {

    @Test
    public void test() throws InterruptedException {
        @SuppressWarnings("deprecation")
        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        BlockingQueue<String> queue = client.getQueue("queue");
        queue.put("Hello!");
        System.out.println("Message send by client!");
        assertTrue(queue.contains("Hello!"));
        client.shutdown();

    }

    @Test
    public void addDataToMap() {
        Config cfg = new Config();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        Map<Integer, String> mapCustomers = instance.getMap("customers");
        mapCustomers.clear();
        mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");

        System.out.println("Customer with key 1: " + mapCustomers.get(1));
        System.out.println("Map Size:" + mapCustomers.size());
        assertEquals(mapCustomers.get(1), "Joe");
        assertNotEquals(mapCustomers.get(3), "Joe");
        Queue<String> queueCustomers = instance.getQueue("customers");
        queueCustomers.clear();
        queueCustomers.offer("Tom");
        queueCustomers.offer("Mary");
        queueCustomers.offer("Jane");
        assertEquals(3, queueCustomers.size());
        System.out.println("First customer: " + queueCustomers.poll());
        System.out.println("Second customer: " + queueCustomers.peek());
        mapCustomers.clear();
        queueCustomers.remove();
        instance.shutdown();
    }

    @Test
    public void getData(){
        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("customers");

        System.out.println("Map Size:" + map.size());
        map.destroy();
        client.shutdown();
    }
}
