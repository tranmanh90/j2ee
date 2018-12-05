package com.book.store.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookCoverMapper;
import com.book.store.model.BookCover;

@Repository
public class BookCoverDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT BC.ID, BC.BOOK_ID, BC.IMAGE_ID FROM BOOK_COVER BC";

	@Autowired
	public BookCoverDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public BookCover getBookCover(String bookId) {
		String sql = BASE_SQL + " WHERE BC.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookCoverMapper mapper = new BookCoverMapper();
		try {
			BookCover bookCover = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return bookCover;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
}
