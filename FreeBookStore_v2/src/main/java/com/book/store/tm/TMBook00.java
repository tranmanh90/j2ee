package com.book.store.tm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.BaseRespone;
import com.book.store.IBasePM;
import com.book.store.IBaseTM;
import com.book.store.dto.Book00Request;
import com.book.store.dto.Book00Response;
import com.book.store.pm.PMBook00;

@RestController
public class TMBook00 implements IBaseTM<Book00Request, Book00Response> {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IBasePM<Book00Request, Book00Response> pm = new PMBook00();

	@RequestMapping(value = "/freebookstore/api/v2/get-book-by-title", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody Book00Request request) {
		logger.info("BookRequest: " + request.toString());
		Book00Response response = pm.execute(request);
		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

	@Override
	public void postProcess(Book00Request request, Book00Response response) {
		// TODO Auto-generated method stub
	}

}
