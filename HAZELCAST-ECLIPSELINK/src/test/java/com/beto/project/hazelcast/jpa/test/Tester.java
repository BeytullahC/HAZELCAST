package com.beto.project.hazelcast.jpa.test;

import com.beto.project.hazelcast.jpa.enums.EnHazelCast;
import com.beto.project.hazelcast.jpa.util.HazelCastUtil;
import model.entities.Countries;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.Map;

import static com.beto.project.hazelcast.jpa.util.JpaUtil.getEntityManager;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by 912867 on 28.04.2015.
 */
public class Tester {

    private static HazelCastUtil<Countries> hazelCastUtil;
    private String COUNTRY_ID = "AU";

    @BeforeClass
    public static void before() {
        hazelCastUtil = new HazelCastUtil<>();
        System.out.println("TEST STARTED..");
    }

    @AfterClass
    public static void after() {
        System.out.println("TEST FINISHED...");
    }

    @Test
    public void TestGetDataFromJpa() {
        assertFalse(getDataFromJpa() == null);
    }

    @Test
    public void TestPutForHZMap() {
        Countries country = getDataFromJpa();
        hazelCastUtil.addDataToMap(EnHazelCast.COUNTRIES, country.getCountryId(), country);
    }

    @Test
    public void TestGetFromHZMap() {
        Map<Object, Countries> map = hazelCastUtil.getDataToMap(EnHazelCast.COUNTRIES);
        System.out.println(map.get(COUNTRY_ID));
        assertNotEquals(null, map.get(COUNTRY_ID));
    }

    public Countries getDataFromJpa() {
        TypedQuery<Countries> q = getEntityManager().createQuery("select c from Countries c where c.countryId=:countryId", Countries.class);
        q.setParameter("countryId", COUNTRY_ID);
        Countries response = q.getSingleResult();
        getEntityManager().close();
        return response;
    }
}
