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
import com.book.store.dto.Book04Request;
import com.book.store.dto.Book04Response;
import com.book.store.pm.PMBook04;

/**************************************************************
 * <pre>
* Search book by containing words transaction main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
@RestController
public class TMBook04 implements IBaseTM<Book04Request, Book04Response> {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IBasePM<Book04Request, Book04Response> pm = new PMBook04();

	/**************************************************************
	 * <pre>
	* Search book by title
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Author array
	 *************************************************************/
	@RequestMapping(value = "/freebookstore/api/v2/search-book-by-containing-words", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BaseRespone[] execute(@RequestBody Book04Request request) {
		logger.info("BookRequest: " + request.toString());
		Book04Response response = pm.execute(request);
		List<BaseRespone> resultDto = new ArrayList<>();
		resultDto.add(response);
		return resultDto.toArray(new BaseRespone[resultDto.size()]);
	}

	@Override
	public void postProcess(Book04Request request, Book04Response response) {
		// TODO Auto-generated method stub
	}

}
