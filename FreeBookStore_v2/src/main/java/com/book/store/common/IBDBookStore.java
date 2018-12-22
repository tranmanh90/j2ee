package com.book.store.common;

import java.util.ArrayList;
import java.util.List;

import com.book.store.bf.RetrieveBookDetailList;
import com.book.store.bf.SearchBookById;
import com.book.store.vo.Book00VO;

public class IBDBookStore implements IIBookStore {

	@Override
	public List<Book00VO> retrieveBookDetailList(Book00VO vo) {
		RetrieveBookDetailList retrieveBookDetailList = new RetrieveBookDetailList();
		List<Book00VO> listBook = new ArrayList<>();
		listBook = retrieveBookDetailList.execute(vo);
		return listBook;
	}

	@Override
	public List<Book00VO> searchBookById(Book00VO vo) {
		SearchBookById searchBookById = new SearchBookById();
		List<Book00VO> listBook = new ArrayList<>();
		listBook = searchBookById.execute(vo);
		return listBook;
	}

}
