package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookMapper;
import com.book.store.model.Book;

@Repository
public class BookDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT BK.BOOK_ID, BK.BOOK_TITLE, BK.BOOK_DESCRIPTION, BK.BOOK_PAGE, BK.BOOK_FORMAT, BK.BOOK_EDITION, BK.BOOK_ISBN, BK.POST_DATE FROM BOOKS BK";

	@Autowired
	public BookDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// Read (GET method)
	public List<Book> searchBookByText(String inputText) {
		String sql = BASE_SQL + " WHERE BK.BOOK_TITLE LIKE ?";
		Object[] params = new Object[] { "%"+inputText+"%" };
		BookMapper mapper = new BookMapper();
		try {
			List<Book> books = this.getJdbcTemplate().query(sql, params, mapper);
			return books;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Book> getBook(String bookId) {
		String sql = BASE_SQL + " WHERE BK.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookMapper mapper = new BookMapper();
		try {
			List<Book> book = this.getJdbcTemplate().query(sql, params, mapper);
			System.out.println("book======> "+ book.toString());
			return book;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Book> getBooks() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookMapper mapper = new BookMapper();
		List<Book> listBooks = this.getJdbcTemplate().query(sql, params, mapper);
		return listBooks;
	}

	// Update (PUT method)
	public List<Book> updateBook(Book book) {
		String sqlupdate = "UPDATE BOOKS SET BOOK_TITLE = '" 	+ book.getBookTitle() 
							 + "', BOOK_DESCRIPTION = '" 		+ book.getBookDescription() 
							 + "', BOOK_PAGE = '" 				+ book.getBookPage() 
							 + "', BOOK_FORMAT = '" 			+ book.getBookFormat() 
							 + "', BOOK_EDITION = '" 			+ book.getBookEdition() 
							 + "', BOOK_ISBN = '" 				+ book.getBookISBN() 
							 + "', POST_DATE = '" 				+ book.getPostDate() 
							 + "' WHERE BOOK_ID = '" 			+ book.getBookId() 
							 + "'";
		this.getJdbcTemplate().update(sqlupdate);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookMapper mapper = new BookMapper();
		List<Book> listBooks = this.getJdbcTemplate().query(sql, params, mapper);
		return listBooks;
	}

	// Create (POST method)
	public List<Book> createBook(Book book) {
		String sqlcreate = "INSERT INTO BOOKS VALUES('" 
															+ book.getBookId() + "','" 
															+ book.getBookTitle() + "','" 
															+ book.getBookDescription() + "','"
															+ book.getBookPage() + "','"
															+ book.getBookFormat() + "','"
															+ book.getBookEdition() + "','"
															+ book.getBookISBN() + "','"
															+ book.getPostDate() + "')";
		this.getJdbcTemplate().update(sqlcreate);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookMapper mapper = new BookMapper();
		List<Book> listBooks = this.getJdbcTemplate().query(sql, params, mapper);
		return listBooks;
	}

	// Delete (DELETE method)
	public List<Book> deleteBook(String bookId) {
		String sqldlt = "DELETE FROM BOOKS WHERE BOOK_ID = '" + bookId + "'";
		this.getJdbcTemplate().update(sqldlt);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookMapper mapper = new BookMapper();
		List<Book> listBooks = this.getJdbcTemplate().query(sql, params, mapper);
		return listBooks;
	}

}
