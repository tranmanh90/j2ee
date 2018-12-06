package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.BookCategory;

public class BookCategoryMapper implements RowMapper<BookCategory> {

	@Override
	public BookCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		String bookId = rs.getString("BOOK_ID");
		String categoryId = rs.getString("CATEGORY_ID");
		return new BookCategory(bookId, categoryId);
	}

}
