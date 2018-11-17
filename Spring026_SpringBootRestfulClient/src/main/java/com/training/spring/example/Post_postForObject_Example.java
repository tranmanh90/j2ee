package com.training.spring.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Post_postForObject_Example {
	public static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee/create";

	public static void main(String[] arg) {
		String empNo = "E09";

		Employee newEmployee = new Employee(empNo, "Manh", "Cleck");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		headers.setContentType(MediaType.APPLICATION_XML);

		RestTemplate restTemplate = new RestTemplate();

		// Dữ liệu đính kèm theo yêu cầu.
		HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);

		// Gửi yêu cầu với phương thức POST.
		Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, Employee.class);

		if (e != null && e.getEmpNo() != null) {

			System.out.println("Employee created: " + e.getEmpNo());
		} else {
			System.out.println("Something error!");
		}

	}
}
