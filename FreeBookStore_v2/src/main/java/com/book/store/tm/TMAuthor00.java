package com.book.store.tm;

import org.springframework.web.bind.annotation.RestController;

import com.book.store.IBaseTM;
import com.book.store.dto.Author00Request;
import com.book.store.dto.Author00Response;

@RestController
public class TMAuthor00 implements IBaseTM<Author00Request, Author00Response> {

	@Override
	public void postProcess(Author00Request request, Author00Response response) {
		// TODO Auto-generated method stub

	}

}
