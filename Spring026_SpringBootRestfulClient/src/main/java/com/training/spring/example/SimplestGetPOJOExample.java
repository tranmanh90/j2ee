package com.training.spring.example;

import org.springframework.web.client.RestTemplate;

public class SimplestGetPOJOExample {
	public static final String URL_EMPLOYEES = "http://localhost:8080/employees";

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		// Gửi yêu cầu với phương thức GET và Headers mặc định.
		Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);

		if (list != null) {
			for (Employee e : list) {
				System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName() + " - " + e.getPosition());
			}
		}

	}
}
