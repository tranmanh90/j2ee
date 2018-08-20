package com.training.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostXmlObject {
	public static void main(String[] arg) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees");
		Employee emp = new Employee("E07", "Tran Van D", "Director");

		// Gửi xml và nhận lại xml
		ClientResponse response = webResource.type("application/xml").accept("application/xml")
				.post(ClientResponse.class, emp);

		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from server....");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
