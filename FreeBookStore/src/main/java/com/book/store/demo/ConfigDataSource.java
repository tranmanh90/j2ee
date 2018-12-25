package com.book.store.demo;

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
	@ConfigurationProperties(prefix = "application.properties")
	@Bean
	@Primary
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}
}
