package com.training.webservice;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetXmlAsObject {
	public static void main(String[] arg) {

		ClientConfig clientConfig = new DefaultClientConfig();

		// Tạo đối tượng client dựa trên cấu hình
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/RSJerseyCRUD/rest/employees/E02/get");

		Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type",
				MediaType.APPLICATION_XML);

		ClientResponse response = builder.get(ClientResponse.class);

		// Trạng thái thành công là 200
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from server...");

		Employee employee = (Employee) response.getEntity(Employee.class);

		System.out.println(employee);
	}
}
