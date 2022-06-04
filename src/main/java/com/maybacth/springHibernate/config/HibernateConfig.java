package com.maybacth.springHibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


//projede resources in altindaki aplication.properties path ini veriyoruz.
@PropertySource(value= {"classpath:application.properties"})
@Configuration
public class HibernateConfig {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driverclass;
	@Value("${spring.hibernate.database-platform}")
	private String platform;
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, username, password);
		driverManagerDataSource.setDriverClassName(driverclass);
		return driverManagerDataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",platform);
		properties.put("hibernaate.show.sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] {"com.maybacth.springHibernate.model"}); //Employee class in bulundugu package in path  ini yaziyoruz.
		return factory; //
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();	
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
}
