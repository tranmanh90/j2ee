package com.training.webservice;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetXmlAsList {
	public static void main(String[] arg) {
		ClientConfig clientConfig = new DefaultClientConfig();

		// Tao doi tuong client dua tren cau hinh
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees");

		Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type",
				MediaType.APPLICATION_XML);

		ClientResponse response = builder.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println(error);
			return;
		}

		GenericType<List<Employee>> genericType = new GenericType<List<Employee>>() {

		};

		List<Employee> list = response.getEntity(genericType);

		System.out.println("Output from server...");

		for (Employee emp : list) {
			System.out.println("-----------------");
			System.out.println(emp);
		}
	}
}
