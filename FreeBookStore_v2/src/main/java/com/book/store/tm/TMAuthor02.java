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
import com.book.store.dto.Author02Request;
import com.book.store.dto.Author02Response;
import com.book.store.pm.PMAuthor01;
import com.book.store.pm.PMAuthor02;

@RestController
public class TMAuthor02 implements IBaseTM<Author02Request, Author02Response> {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IBasePM<Author02Request, Author02Response> pm = new PMAuthor02();

	
	/**************************************************************
	 * <pre>
	* Search author by name
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Author array
	 *************************************************************/
	@RequestMapping(value = "/freebookstore/api/v2/register-author", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody Author02Request request) {
		Author02Response response = pm.execute(request);
		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

	@Override
	public void postProcess(Author02Request request, Author02Response response) {
		// TODO Auto-generated method stub

	}

}