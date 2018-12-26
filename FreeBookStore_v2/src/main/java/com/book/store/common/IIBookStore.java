package com.book.store.common;

import java.util.List;

import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;
import com.book.store.vo.Book02VO;
import com.book.store.vo.Book03VO;
import com.book.store.vo.Book04VO;

public interface IIBookStore {
	public List<Book00VO> searchBookByTitle(Book00VO vo);

	public List<Book01VO> searchBookById(Book01VO vo);

	public List<Book02VO> searchBookByAuthor(Book02VO vo);

	public List<Book03VO> searchBookByCategory(Book03VO vo);

	public List<Book04VO> searchBookByContainingWords(Book04VO vo);

	public List<Author00VO> searchAuthorByName(Author00VO vo);

	public List<Author00VO> searchAuthorById(Author00VO vo);

}
