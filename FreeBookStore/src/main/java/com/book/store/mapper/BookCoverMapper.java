package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.BookCover;

public class BookCoverMapper implements RowMapper<BookCover> {

	@Override
	public BookCover mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("ID");
		String bookId = rs.getString("BOOK_ID");
		String imageId = rs.getString("IMAGE_ID");

		return new BookCover(id, bookId, imageId);
	}

}
