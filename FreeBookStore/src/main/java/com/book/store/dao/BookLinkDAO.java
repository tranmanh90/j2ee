package com.book.store.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookLinkMapper;
import com.book.store.model.BookLink;

@Repository
public class BookLinkDAO extends JdbcDaoSupport {

	private static final String BASE_BOOK_LINK_SQL = "SELECT BL.BOOK_ID, BL.LINK_ID FROM BOOK_LINK BL";

	@Autowired
	public BookLinkDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public BookLink getBookLink(String bookId) {
		String sql = BASE_BOOK_LINK_SQL + " WHERE BL.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookLinkMapper mapper = new BookLinkMapper();
		try {
			BookLink bookLink = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return bookLink;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
