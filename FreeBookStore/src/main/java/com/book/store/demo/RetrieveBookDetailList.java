package com.book.store.demo;
// Đây là BF

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class RetrieveBookDetailList {
	
	@Autowired
	private Dbook df;

	public List<Book00VO> execute(Book00VO vo) {
		List<Book00VO> returnList = null;
		returnList = df.s000(vo);
		return returnList;
	}
}