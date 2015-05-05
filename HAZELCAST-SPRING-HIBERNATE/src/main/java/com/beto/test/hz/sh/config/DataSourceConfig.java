package com.beto.test.hz.sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.beto.test.*")
@PropertySource("classpath:database.properties")
public class DataSourceConfig {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_GEN_DDL_MODE = "hbm2ddl.mode";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUsername(env.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        dataSource.setUrl(env.getProperty(PROPERTY_NAME_DATABASE_URL));
        return dataSource;
    }

    @Bean
    public Properties hibProperties() {
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_NAME_HIBERNATE_DIALECT, env.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        //properties.setProperty(PROPERTY_NAME_HIBERNATE_GEN_DDL, env.getProperty(PROPERTY_NAME_HIBERNATE_GEN_DDL));
        properties.setProperty(PROPERTY_NAME_HIBERNATE_GEN_DDL_MODE, env.getProperty(PROPERTY_NAME_HIBERNATE_GEN_DDL_MODE));
        properties.setProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(env.getProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        transactionManager.setTransactionSynchronization(AbstractPlatformTransactionManager.SYNCHRONIZATION_ALWAYS);
        return transactionManager;
    }

}
