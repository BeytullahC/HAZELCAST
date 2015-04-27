package com.beto.project.hazelcast.jpa.test;

import com.beto.project.hazelcast.jpa.entities.Countries;
import com.beto.project.hazelcast.jpa.entities.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class TesterJpa {

    private static EntityManagerFactory factory;
    private static EntityManager em;

    @BeforeClass
    public static void before() {
        System.out.println("TEST STARTED..");
        factory = Persistence.createEntityManagerFactory(Parameters.TEST_PERSISTANCE_UNIT);
        em = factory.createEntityManager();
    }

    @Test
    public void testGetData() {
        TypedQuery<Countries> q = em.createQuery("select c from Countries c", Countries.class);
        List<Countries> response = q.getResultList();
        em.close();
        assertFalse(response.isEmpty());
    }
}
