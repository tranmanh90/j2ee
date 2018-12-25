package com.book.store.common;

import java.util.ArrayList;
import java.util.List;

import com.book.store.bf.SearchAuthorById;
import com.book.store.bf.SearchAuthorByName;
import com.book.store.bf.SearchBookById;
import com.book.store.bf.SearchBookByTitle;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;

public class IBDBookStore implements IIBookStore {

	/**************************************************************
	 * <pre>
	* Search book by title
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return List of searched book
	 *************************************************************/
	@Override
	public List<Book00VO> searchBookByTitle(Book00VO vo) {
		SearchBookByTitle searchBookByTitle = new SearchBookByTitle();
		List<Book00VO> listBook = new ArrayList<>();
		listBook = searchBookByTitle.execute(vo);
		return listBook;
	}

	/**************************************************************
	 * <pre>
	* Search book by id
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return The searched book
	 *************************************************************/
	@Override
	public List<Book01VO> searchBookById(Book01VO vo) {
		SearchBookById searchBookById = new SearchBookById();
		List<Book01VO> listBook = new ArrayList<>();
		listBook = searchBookById.execute(vo);
		return listBook;
	}

	/**************************************************************
	 * <pre>
	* Search author by name
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return The searched author
	 *************************************************************/
	@Override
	public List<Author00VO> searchAuthorByName(Author00VO vo) {
		SearchAuthorByName searchAuthorByName = new SearchAuthorByName();
		List<Author00VO> listAuthor = new ArrayList<>();
		listAuthor = searchAuthorByName.execute(vo);
		return listAuthor;
	}

	/**************************************************************
	 * <pre>
	* Search author by id
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return The searched author
	 *************************************************************/
	@Override
	public List<Author00VO> searchAuthorById(Author00VO vo) {
		SearchAuthorById searchAuthorById = new SearchAuthorById();
		List<Author00VO> listAuthor = new ArrayList<>();
		listAuthor = searchAuthorById.execute(vo);
		return listAuthor;
	}

}
