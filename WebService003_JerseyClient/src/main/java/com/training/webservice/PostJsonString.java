package com.training.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostJsonString {
	public static void main(String[] arg) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees");

		// Dữ liệu gửi đi cùng request
		String input = "{\"employeeNumber\": \"E04\",\"employeeName\": \"Tran Van B\",\"employeePosition\": \"Clerk\"}";

		ClientResponse response = webResource.type("application/json").accept("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from server...");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
