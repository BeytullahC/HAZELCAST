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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;

/**
 *
 * @author 912867
 */
public class Tester {
    static Config cfg = new Config();
    static HazelcastInstance instance;
    static ClientConfig clientConfig;
    static HazelcastInstance client;
    static Queue<String> queueCustomers;
    static Map<Integer, String> mapCustomers;
    static IMap map;


    @BeforeClass
    public static void testInit() {
        System.out.println("BEFORE RUNNING");
        instance = Hazelcast.newHazelcastInstance(cfg);
        clientConfig = new ClientConfig();
        client = HazelcastClient.newHazelcastClient(clientConfig);
    }

    @AfterClass
    public static void destroy() {
        System.out.println("AFTER RUNNING");
        queueCustomers.clear();
        mapCustomers.clear();
        client.shutdown();
    }

    @Test
    public void addDataToQueue() throws InterruptedException {
        @SuppressWarnings("deprecation")
        BlockingQueue<String> queue = client.getQueue("queue");
        queue.put("Hello!");
        System.out.println("Message send by client!");
        assertTrue(queue.contains("Hello!"));
    }

    @Test
    public void addDataToMap() {
        mapCustomers = instance.getMap("customers");
        mapCustomers.clear();
        mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");
        queueCustomers = instance.getQueue("customers");
        queueCustomers.clear();
        queueCustomers.offer("Tom");
        queueCustomers.offer("Mary");
        queueCustomers.offer("Jane");
    }

    @Test
    public void getDataToMap() {
        map = client.getMap("customers");
        System.out.println("Map Size:" + map.size());
        System.out.println("Customer with key 1: " + map.get(1));
        System.out.println("Map Size:" + map.size());
        assertEquals(map.get(1), "Joe");
        assertNotEquals(map.get(3), "Joe");
    }

    @Test
    public void getDataToQueue() {
        System.out.println("First customer: " + queueCustomers.poll());
        System.out.println("Second customer: " + queueCustomers.peek());
        System.out.println(queueCustomers.size());
        assertEquals(2, queueCustomers.size());
        assertEquals("Mary", queueCustomers.poll());
        assertEquals("Jane", queueCustomers.poll());
        System.out.println(queueCustomers.size());
    }
}
