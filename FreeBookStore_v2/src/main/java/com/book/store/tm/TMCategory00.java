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
import com.book.store.dto.Category00Request;
import com.book.store.dto.Category00Response;
import com.book.store.pm.PMCategory00;


@RestController
public class TMCategory00 implements IBaseTM<Category00Request, Category00Response> {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IBasePM<Category00Request, Category00Response> pm = new PMCategory00();

	
	/**************************************************************
	 * <pre>
	* Search Category by name
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Category array
	 *************************************************************/
	@RequestMapping(value = "/freebookstore/api/v2/search-category-by-id", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody Category00Request request) {
		Category00Response response = pm.execute(request);
		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

	@Override
	public void postProcess(Category00Request request, Category00Response response) {
		// TODO Auto-generated method stub

	}

}
