package com.beto.project.hazelcast.jpa;

import com.beto.test.hz.enums.EnHazelCast;
import com.beto.test.hz.sh.config.DataSourceConfig;
import com.beto.test.hz.sh.dao.CountriesDao;
import com.beto.test.hz.sh.entities.Countries;
import com.beto.test.hz.util.HazelCastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Map;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by 912867 on 04.05.2015.
 */
@Test
@ContextConfiguration(classes = {DataSourceConfig.class})
@TransactionConfiguration(defaultRollback = true)
public class TestSh extends AbstractTransactionalTestNGSpringContextTests {

    private String COUNTRY_ID = "AR";
    @Autowired
    private CountriesDao dao;

    private static HazelCastUtil<Countries> hazelCastUtil;

    @BeforeClass
    public static void before() {
        hazelCastUtil = new HazelCastUtil<>();
        System.out.println("TEST STARTED..");
    }

    @AfterClass
    public static void after() {
        System.out.println("TEST FINISHED...");
    }

    @Override
    @BeforeMethod(alwaysRun = true)
    protected synchronized void springTestContextBeforeTestMethod(
            Method testMethod) throws Exception {
        super.springTestContextBeforeTestMethod(testMethod);
    }

    @Override
    @AfterMethod(alwaysRun = true)
    protected synchronized void springTestContextAfterTestMethod(
            Method testMethod) throws Exception {
        super.springTestContextAfterTestMethod(testMethod);
    }

    @Test()
    public void test() {
        assertTrue(true);
    }

    @Test()
    public void TestSessionFactory() {
        assertNotEquals(null, dao);
    }

    @Test()
    public void TestCurrentSession() {
        System.out.println(dao.test("AR"));
        assertNotEquals(null, dao.test("AR"));
    }

    @Test
    public void TestPutForHZMap() {
        Countries country = getData();
        hazelCastUtil.addDataToMap(EnHazelCast.COUNTRIES, country.getCountryId(), country);
    }

    @Test
    public void TestGetFromHZMap() {
        Map<Object, Countries> map = hazelCastUtil.getDataToMap(EnHazelCast.COUNTRIES);
        System.out.println("GELEN : " + map.size() + " data " + map.get(COUNTRY_ID));
        assertNotEquals(null, map.get(COUNTRY_ID));
    }

    public Countries getData() {
        return dao.test(COUNTRY_ID);
    }

}
