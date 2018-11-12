package com.training.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.training.spring.routing.MyRoutingDataSource;

@SpringBootApplication

//Disable Auto Config DataSource & DataSourceTransactionManager
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })

//Load to Environment
//(@see resources/datasource-cfg.properties).
@PropertySources({ @PropertySource("classpath:datasources.properties") })
public class Spring019SpringBootMultiDataSourceRoutingDataSourceApplication {

	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	@Autowired
	private Environment env;

	// Returns Routing DataSource (MyRoutingDataSource)
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource(DataSource dataSource1, DataSource dataSource2) {
		MyRoutingDataSource routingDataSource = new MyRoutingDataSource();
		routingDataSource.initDataSource(dataSource1, dataSource2);
		return routingDataSource;
	}

	@Bean(name = "dataSource1")
	public DataSource getDataSource1() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.1"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.1"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.1"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.1"));

		return dataSource;
	}

	@Bean(name = "dataSource2")
	public DataSource getDataSource2() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.2"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.2"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.2"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.2"));

		return dataSource;
	}
	
	   @Autowired
	   @Bean(name = "transactionManager")
	   public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	      DataSourceTransactionManager txManager = new DataSourceTransactionManager();
	 
	      txManager.setDataSource(dataSource);
	 
	      return txManager;
	   }

	public static void main(String[] args) {
		SpringApplication.run(Spring019SpringBootMultiDataSourceRoutingDataSourceApplication.class, args);
	}
}
