package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringComponent {

	@Autowired
	private SpringRepository repository;

	public void showAppInfo() {
		System.out.println("Now is: " + repository.getSystemDate());
		System.out.println("App Name: " + repository.getAppName());
	}
}
