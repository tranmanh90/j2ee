package com.training.spring.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWithHeaderExample {
	static final String URL_EMPLOYEES = "http://54.145.176.109/freebookstore/api/v2/search-book-by-title";

	public static void main(String[] arg) throws IOException {

		URL urlForGetRequest = new URL("http://54.145.176.109/freebookstore/api/v2/search-book-by-title");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		conection.setRequestProperty("page", "1"); // set userId its a sample here
		conection.setRequestProperty("rowPerPage", "10"); // set userId its a sample here
		conection.setRequestProperty("bookTitle", "spring"); // set userId its a sample here
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			// print result
			System.out.println("JSON String Result " + response.toString());
			// GetAndPost.POSTRequest(response.toString());
		} else {
			System.out.println("GET NOT WORKED");
		}
	}
}
