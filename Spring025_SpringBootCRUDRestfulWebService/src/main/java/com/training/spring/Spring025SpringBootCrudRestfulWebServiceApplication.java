package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Spring025SpringBootCrudRestfulWebServiceApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Spring025SpringBootCrudRestfulWebServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring025SpringBootCrudRestfulWebServiceApplication.class, args);
	}
}
