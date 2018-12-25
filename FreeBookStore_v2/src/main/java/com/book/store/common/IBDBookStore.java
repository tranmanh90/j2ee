package com.book.store.common;

import java.util.ArrayList;
import java.util.List;

import com.book.store.bf.SearchAuthorById;
import com.book.store.bf.SearchAuthorByName;
import com.book.store.bf.SearchBookByAuthor;
import com.book.store.bf.SearchBookByCategory;
import com.book.store.bf.SearchBookById;
import com.book.store.bf.SearchBookByTitle;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;
import com.book.store.vo.Book02VO;
import com.book.store.vo.Book03VO;

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

	/**************************************************************
	 * <pre>
	* Search book by author id
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return The searched author
	 *************************************************************/
	@Override
	public List<Book02VO> searchBookByAuthor(Book02VO vo) {
		SearchBookByAuthor searchBookByAuthor = new SearchBookByAuthor();
		List<Book02VO> listBooks = new ArrayList<>();
		listBooks = searchBookByAuthor.execute(vo);
		return listBooks;
	}

	/**************************************************************
	 * <pre>
	* Search book by category id
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return List of searched book
	 *************************************************************/
	@Override
	public List<Book03VO> searchBookByCategory(Book03VO vo) {
		SearchBookByCategory searchBookByCategory = new SearchBookByCategory();
		List<Book03VO> listBooks = new ArrayList<>();
		listBooks = searchBookByCategory.execute(vo);
		return listBooks;
	}

}
