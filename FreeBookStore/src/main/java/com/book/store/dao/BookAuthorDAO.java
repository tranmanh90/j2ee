package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookAuthorMapper;
import com.book.store.model.BookAuthor;

@Repository
public class BookAuthorDAO extends JdbcDaoSupport {
	private static final String BASE_SQL = "SELECT BA.ID, BA.BOOK_ID, BA.AUTHOR_ID FROM BOOK_AUTHOR BA";

	@Autowired
	public BookAuthorDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	
	public BookAuthor getBookAuthor(String bookId) {
		String sql = BASE_SQL + " WHERE BA.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookAuthorMapper mapper = new BookAuthorMapper();
		try {
			BookAuthor bookAuthor = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return bookAuthor;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	public List<BookAuthor> getBookAuthors(String bookId) {
		String sql = BASE_SQL + " WHERE BA.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookAuthorMapper mapper = new BookAuthorMapper();
		try {
			List<BookAuthor> bookAuthors = this.getJdbcTemplate().query(sql, params, mapper);
			return bookAuthors;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
