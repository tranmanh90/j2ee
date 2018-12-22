package com.book.store.bf;
// Đây là BF

import java.util.List;

import com.book.store.df.Dbook;
import com.book.store.vo.Book00VO;


public class RetrieveBookDetailList {
	
	private Dbook df = new Dbook();

	public List<Book00VO> execute(Book00VO vo) {
		List<Book00VO> returnList = null;
		returnList = df.s000(vo);
		return returnList;
	}
}