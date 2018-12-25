package com.training.spring.example;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetPOJOWithHeaderExample {
	public static final String URL_EMPLOYEES = "http://54.145.176.109/freebookstore/api/v2/search-book-by-title";

	public static void main(String[] arg) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.set("my_key", "my_value");

		HttpEntity<Employee[]> entity = new HttpEntity<Employee[]>(headers);

		RestTemplate template = new RestTemplate();

		ResponseEntity<Employee[]> respone = template.exchange(URL_EMPLOYEES, HttpMethod.GET, entity, Employee[].class);

		HttpStatus status = respone.getStatusCode();
		System.out.println("Status code: " + status);

		if (status == HttpStatus.OK) {
			Employee[] list = respone.getBody();

			if (list != null) {
				for (Employee e : list) {
					System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
				}
			}
		}
	}
}
