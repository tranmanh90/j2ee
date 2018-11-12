package com.training.spring.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.training.spring.interceptor.DataSourceInterceptor;

public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DataSourceInterceptor()).addPathPatterns("/publisher/*", "/advertiser/*");
	}

}
