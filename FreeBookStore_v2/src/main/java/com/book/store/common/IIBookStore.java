package com.book.store.common;

import java.util.List;

import com.book.store.vo.Book00VO;

public interface IIBookStore {
	public List<Book00VO> retrieveBookDetailList(Book00VO vo);

	public List<Book00VO> searchBookById(Book00VO vo);
}
