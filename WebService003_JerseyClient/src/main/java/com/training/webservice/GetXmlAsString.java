package com.training.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetXmlAsString {
	public static void main(String[] arg) {
		// Tạo đối tượng client

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees/E02/get");

		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

		// Kiểm tra trạng thái có thành công hay không, 200 là thành công
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		String output = response.getEntity(String.class);
		System.out.println("Output from server...");
		System.out.println(output);
	}
}
