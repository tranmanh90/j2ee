package com.book.store.pm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.BookConstant;
import com.book.store.IBasePM;
import com.book.store.common.IBDBookStore;
import com.book.store.common.IIBookStore;
import com.book.store.dto.Author01Dto;
import com.book.store.dto.Author02Request;
import com.book.store.dto.Author02Response;
import com.book.store.dto.Author02Request;
import com.book.store.dto.Author02Response;
import com.book.store.vo.Author00VO;

public class PMAuthor02 implements IBasePM<Author02Request, Author02Response>{
	
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IIBookStore iibt = new IBDBookStore();

	/**************************************************************
	 * <pre>
	* Execute action search
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Response object
	 *************************************************************/
	@Override
	public Author02Response execute(Author02Request request) {
		Author02Response response = new Author02Response();
		response = registerAuthor(request);
		return response;
	}

	private Author02Response registerAuthor(Author02Request request) {
		Author00VO inVO = null;
		Author02Response response = new Author02Response();
		inVO = toVO(request);
		
		List<Author00VO> checkData = iibt.searchAuthorById(inVO);
		
		if(checkData != null && !checkData.isEmpty()) {
			response.setRspCd("0001");
			response.setRspMsg("The ID is already registed");
			return response;
		}
		
		int result = iibt.registerAuthor(inVO);
		response = toDTO(result);
		return response;
	}

	private Author00VO toVO(Author02Request request) {
		Author00VO vo = new Author00VO();
		vo.setAuthorAbout(request.getAuthorAbout());
		vo.setAuthorId(request.getAuthorId());
		vo.setAuthorName(request.getAuthorName());
		return vo;
	}

	private Author02Response toDTO(int result) {
		Author02Response response = new Author02Response();
		response.setRspCd("0000");
		return response;
	}

}
