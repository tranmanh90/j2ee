package com.training.spring.example;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetWithBasicAuthExample {
	public static final String USER_NAME = "tom";
	public static final String PASSWORD = "123";

	static final String URL_EMPLOYEES = "http://localhost:8080/employees";

	public static void main(String[] arg) {
		HttpHeaders headers = new HttpHeaders();

		// Auth
		String auth = USER_NAME + ":" + PASSWORD;
		byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodeAuth);
		headers.set("Authorization", authHeader);

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Yêu cầu trả về định dạng JSON
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("my_other_key", "my_other_value");

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Gửi yêu cầu với phương thức GET, và các thông tin Headers.
		ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
				HttpMethod.GET, entity, String.class);

		String result = response.getBody();

		System.out.println(result);
	}
}
