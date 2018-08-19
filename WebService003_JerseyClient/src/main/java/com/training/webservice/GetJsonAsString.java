package com.training.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetJsonAsString {
	public static void main(String[] arg) {

		Client client = Client.create();

		WebResource resource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees/E02/get");

		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);

		// Trạng thái 200 là thành công
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP Error code: " + response.getStatus());
			String err = response.getEntity(String.class);
			System.out.println("Error: " + err);
			return;
		}

		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}
}
