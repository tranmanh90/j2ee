package com.book.store.common;

import java.util.List;

import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;

public interface IIBookStore {
	public List<Book00VO> searchBookByTitle(Book00VO vo);

	public List<Book01VO> searchBookById(Book01VO vo);

	public List<Author00VO> searchAuthorByName(Author00VO vo);
}
