package com.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.training.spring" })
public class AppConfig {
	@Bean(name = "language")
	public Language getLanguage() {
		return new Vietnamese();
	}
}
