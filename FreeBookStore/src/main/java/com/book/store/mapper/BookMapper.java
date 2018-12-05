package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		String bookId 			= rs.getString("BOOK_ID");
		String bookTitle		= rs.getString("BOOK_TITLE");
		String bookDescription	= rs.getString("BOOK_DESCRIPTION");
		String bookPage			= rs.getString("BOOK_PAGE");
		String bookFormat		= rs.getString("BOOK_FORMAT");
		String bookEdition		= rs.getString("BOOK_EDITION");
		String bookISBN			= rs.getString("BOOK_ISBN");
		String postDate			= rs.getString("POST_DATE");
		
		return new Book(bookId, bookTitle, bookDescription, bookPage, bookFormat, bookEdition, bookISBN, postDate);
	}
}
