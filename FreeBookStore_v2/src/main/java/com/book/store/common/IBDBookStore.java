package com.book.store.common;

import java.util.ArrayList;
import java.util.List;

import com.book.store.bf.SearchBookById;
import com.book.store.bf.SearchBookByTitle;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;

public class IBDBookStore implements IIBookStore {

	@Override
	public List<Book00VO> searchBookByTitle(Book00VO vo) {
		SearchBookByTitle searchBookByTitle = new SearchBookByTitle();
		List<Book00VO> listBook = new ArrayList<>();
		listBook = searchBookByTitle.execute(vo);
		return listBook;
	}

	@Override
	public List<Book01VO> searchBookById(Book01VO vo) {
		SearchBookById searchBookById = new SearchBookById();
		List<Book01VO> listBook = new ArrayList<>();
		listBook = searchBookById.execute(vo);
		return listBook;
	}

}
