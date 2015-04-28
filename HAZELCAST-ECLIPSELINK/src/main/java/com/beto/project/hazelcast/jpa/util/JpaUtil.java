package com.beto.project.hazelcast.jpa.util;

import com.beto.project.hazelcast.jpa.Parameters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by 912867 on 28.04.2015.
 */
public class JpaUtil {
    private static EntityManagerFactory factory;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory(Parameters.TEST_PERSISTANCE_UNIT);
        return factory.createEntityManager();
    }
}
