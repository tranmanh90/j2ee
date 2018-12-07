package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.BookLink;

public class BookLinkMapper implements RowMapper<BookLink> {

	@Override
	public BookLink mapRow(ResultSet rs, int rowNum) throws SQLException {
		String bookId = rs.getString("BOOK_ID");
		String linkId = rs.getString("LINK_ID");
		return new BookLink(bookId, linkId);
	}

}
