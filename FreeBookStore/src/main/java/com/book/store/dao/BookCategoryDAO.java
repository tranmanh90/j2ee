package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookCategoryMapper;
import com.book.store.model.BookCategory;

@Repository
public class BookCategoryDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT BC.BOOK_ID, BC.CATEGORY_ID FROM BOOK_CATEGORY BC";

	@Autowired
	public BookCategoryDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public BookCategory getBookCategory(String bookId) {
		String sql = BASE_SQL + " WHERE BC.BOOK_ID = ?";
		Object[] params = new Object[] { bookId };
		BookCategoryMapper mapper = new BookCategoryMapper();
		try {
			BookCategory bookCategory = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return bookCategory;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<BookCategory> getListBookCategories() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookCategoryMapper mapper = new BookCategoryMapper();
		List<BookCategory> listBookCategories = this.getJdbcTemplate().query(sql, params, mapper);
		return listBookCategories;
	}
}
