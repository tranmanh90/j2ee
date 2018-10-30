package com.training.spring;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class SpringRepository {
	public String getAppName() {
		return "Hello Spring";
	}

	public Date getSystemDate() {
		return new Date();
	}
}
