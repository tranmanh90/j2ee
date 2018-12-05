package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.BookAuthor;

public class BookAuthorMapper implements RowMapper<BookAuthor> {

	@Override
	public BookAuthor mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("ID");
		String bookId = rs.getString("BOOK_ID");
		String authorId = rs.getString("AUTHOR_ID");

		return new BookAuthor(id, bookId, authorId);
	}

}
