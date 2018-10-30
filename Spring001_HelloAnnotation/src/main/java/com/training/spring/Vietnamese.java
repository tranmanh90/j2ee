package com.training.spring;

public class Vietnamese implements Language {

	@Override
	public String getGreeting() {
		return "Xin chào";
	}

	@Override
	public String getBye() {
		return "Tạm biệt";
	}

}
