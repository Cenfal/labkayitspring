package com.thy.loyalty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by INNGKISAKOL on 2/8/2018.
 */

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = "com.thy")
@PropertySources({
        @PropertySource("file:${thy.appdir}/loyaltyservices/conf/appparam.txt"),
        @PropertySource("file:${thy.appdir}/loyaltyservices/conf/wsparam.txt")
})
public class AppConfiguration
{
    @Value("${db.jndiName}")
    private String JNDI_NAME;

    @Value("${provider.url}")
    private String PROVIDER_URL;

    @Value("${initial.context.factory}")
    private String INITIAL_CONTEXT_FACTORY;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;

    @Bean
    public DataSource dataSource() throws NamingException
    {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        properties.put(Context.PROVIDER_URL, PROVIDER_URL);
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiEnvironment(properties);
        bean.setJndiName(JNDI_NAME);
        bean.setResourceRef(true);
        bean.setProxyInterface(javax.sql.DataSource.class);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws NamingException
    {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", HIBERNATE_DIALECT);
        properties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        properties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        properties.put("hibernate.format_sql", Boolean.TRUE);
        properties.put("hibernate.use_sql_comments", Boolean.TRUE);
        properties.put("hibernate.enable_lazy_load_no_trans", Boolean.TRUE);
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws NamingException
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
