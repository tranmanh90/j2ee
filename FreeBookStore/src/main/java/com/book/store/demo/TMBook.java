package com.book.store.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMBook {
	
	private IBasePM<BookRequest, BookResponse> pm = new PMBook();

	
	@RequestMapping(value = "/freebookstore/api/v1/get-book-demo1", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody BookRequest request) {
		System.out.println("request TM: " + request.toString());

		BookResponse response = pm.execute(request);

		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

}
