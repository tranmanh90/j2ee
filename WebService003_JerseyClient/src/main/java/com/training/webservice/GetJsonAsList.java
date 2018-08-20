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

public class GetJsonAsList {
	public static void main(String[] arg) {
		ClientConfig clientConfig = new DefaultClientConfig();

		// Tạo đối tượng client dựa trên cấu hình.
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees");

		Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type",
				MediaType.APPLICATION_JSON);

		ClientResponse response = builder.get(ClientResponse.class);

		// Trạng thái thành công là 200
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		GenericType<List<Employee>> generic = new GenericType<List<Employee>>() {
			// nothing
		};

		List<Employee> list = response.getEntity(generic);

		System.out.println("Output from server.... ");
		for (Employee emp : list) {
			System.out.println("------------------");
			System.out.println(emp);
		}
	}
}
