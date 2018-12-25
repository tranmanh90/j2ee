package com.book.store.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ConfigDataSource {
	@ConfigurationProperties("classpath:datasources.properties")
	@Bean
	@Primary
	public static DataSource getDataSource() {
		return DataSourceBuilder.create()
				.username("sa")
				.password("9092hnamnarT,")
				.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.url("jdbc:sqlserver://localhost:1433;databaseName=tranmanh")
				.build();
	}
}
