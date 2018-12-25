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
public class BookController {

	private IBasePM<BookRequest, BookResponse> pm = new PMBook();

	// Get list books
	// http://54.145.176.109/freebookstore/api/v1/get-list-books
//	@RequestMapping(value = "/freebookstore/api/v1/get-list-books-demo", //
//			method = RequestMethod.GET, //
//			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	@ResponseBody
//	public List<Book00VO> getListBookDetails() {
//		Book00VO vo = new Book00VO();
//		System.out.println("dBook: " + dBook);
//		List<Book00VO> outlist = dBook.s000(vo);
//		return outlist;
//	}

	// Get list books
	// http://54.145.176.109/freebookstore/api/v1/get-list-books
	@RequestMapping(value = "/freebookstore/api/v1/get-book-demo", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] getListBook(@RequestBody BookRequest request) {
		System.out.println("request TM: " + request.toString());

		BookResponse response = pm.execute(request);

		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}
}
