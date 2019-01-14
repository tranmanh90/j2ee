package com.book.store.pm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.IBasePM;
import com.book.store.common.IBDBookStore;
import com.book.store.common.IIBookStore;
import com.book.store.dto.Author00Dto;
import com.book.store.dto.Author00Request;
import com.book.store.dto.Author00Response;
import com.book.store.dto.Category00Dto;
import com.book.store.dto.Category00Request;
import com.book.store.dto.Category00Response;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Category00VO;

public class PMCategory00 implements IBasePM<Category00Request, Category00Response>{

	
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IIBookStore iibt = new IBDBookStore();
	
	
	@Override
	public Category00Response execute(Category00Request request) {
		Category00Response response = new Category00Response();
		response = searchCategoryById(request);
		return response;
	}


	private Category00Response searchCategoryById(Category00Request request) {
		Category00VO inVO = null;
		inVO = toVO(request);
		List<Category00VO> outList = iibt.searchCategoryById(inVO);
		Category00Response response = toDTO(outList);
		return response;
	}


	private Category00Response toDTO(List<Category00VO> outList) {
		
		Category00Response category00Response = new Category00Response();
		
		if(outList == null || outList.size() == 0 ) {
			return category00Response;
		}
		
			
		List<Category00Dto> category00Dtos = new ArrayList<>();
		
		for(Category00VO single: outList) {
			Category00Dto dto = new Category00Dto();
			dto.setCategoryId(single.getCategoryId());
			dto.setCategoryName(single.getCategoryName());
			category00Dtos.add(dto);
		}
		
		Category00Dto[] result = category00Dtos.toArray(new Category00Dto[category00Dtos.size()]);
		category00Response.setCatagoryList(result);
		return category00Response;
	}


	private Category00VO toVO(Category00Request request) {
		Category00VO category00vo = new Category00VO();
		category00vo.setCategoryId(request.getCategoryId());
		return category00vo;
	}



}
