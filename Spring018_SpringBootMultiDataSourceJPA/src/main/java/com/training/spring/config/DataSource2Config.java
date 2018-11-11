package com.training.spring.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.training.spring.constant.Constants;

@Configuration
@PropertySources({ @PropertySource("classpath:datasources.properties") })
public class DataSource2Config {
	@Autowired
	private Environment env;

	@Bean
	public DataSource ds1DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.1"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.1"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.1"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.1"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean ds1EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(ds1DataSource());

		// Scan Entities in Package
		em.setPackagesToScan(new String[] { Constants.PACKAGE_ENTITIES_1 });
		em.setPersistenceUnitName(Constants.JPA_UNIT_NAME_1);

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();

		// JPA & Hibernate
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.1"));
		properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.1"));

		em.setJpaPropertyMap(properties);
		em.afterPropertiesSet();
		return em;
	}

	@Bean
	public PlatformTransactionManager ds1TransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(ds1EntityManager().getObject());
		return transactionManager;
	}
}