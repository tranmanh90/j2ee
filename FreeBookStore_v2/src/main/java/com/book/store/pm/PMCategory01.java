package com.book.store.pm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.IBasePM;
import com.book.store.common.IBDBookStore;
import com.book.store.common.IIBookStore;
import com.book.store.dto.Category01Request;
import com.book.store.dto.Category01Request;
import com.book.store.dto.Category01Response;
import com.book.store.dto.Author02Response;
import com.book.store.dto.Category00Request;
import com.book.store.dto.Category00Response;
import com.book.store.dto.Category01Request;
import com.book.store.dto.Category01Response;
import com.book.store.vo.Category00VO;

public class PMCategory01 implements IBasePM<Category01Request, Category01Response>{

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
	public Category01Response execute(Category01Request request) {
		Category01Response response = new Category01Response();
		response = registerCategory(request);
		return response;
	}

	private Category01Response registerCategory(Category01Request request) {
		Category00VO inVO = null;
		Category01Response response = new Category01Response();
		inVO = toVO(request);
		
		List<Category00VO> checkData = iibt.searchCategoryById(inVO);
		
		if(checkData != null && !checkData.isEmpty()) {
			response.setRspCd("0001");
			response.setRspMsg("The ID is already registed");
			return response;
		}
		
		int result = iibt.registerCategory(inVO);
		response = toDTO(result);
		return response;
	}

	private Category00VO toVO(Category01Request request) {
		Category00VO vo = new Category00VO();
		vo.setCategoryId(request.getCategoryId());
		vo.setCategoryName(request.getCategoryName());
		return vo;
	}

	private Category01Response toDTO(int result) {
		Category01Response response = new Category01Response();
		response.setRspCd("0000");
		return response;
	}

}
