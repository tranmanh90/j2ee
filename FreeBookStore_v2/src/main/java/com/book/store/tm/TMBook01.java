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
import com.book.store.dto.Book01Request;
import com.book.store.dto.Book01Response;
import com.book.store.pm.PMBook01;

/**************************************************************
 * <pre>
* Search book by id transaction main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
@RestController
public class TMBook01 implements IBaseTM<Book01Request, Book01Response> {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IBasePM<Book01Request, Book01Response> pm = new PMBook01();

	/**************************************************************
	 * <pre>
	* Search book by id
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Author array
	 *************************************************************/
	@RequestMapping(value = "/freebookstore/api/v2/search-book-by-id", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody Book01Request request) {
		logger.info("BookRequest: " + request.toString());
		Book01Response response = pm.execute(request);
		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

	@Override
	public void postProcess(Book01Request request, Book01Response response) {
		// TODO Auto-generated method stub

	}

}
