package com.book.store.demo;

import java.util.ArrayList;
import java.util.List;

// Đây là triển khai Interface
public class IBDBookStore implements IIBookStore {

	@Override
	public List<Book00VO> retrieveBookDetailList(Book00VO vo) {
		RetrieveBookDetailList retrieveBookDetailList = new RetrieveBookDetailList();
		List<Book00VO> listBook = new ArrayList<>();
		listBook = retrieveBookDetailList.execute(vo);
		return listBook;
	}

}
