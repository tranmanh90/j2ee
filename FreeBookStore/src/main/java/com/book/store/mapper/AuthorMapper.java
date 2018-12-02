package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.Author;

public class AuthorMapper implements RowMapper<Author> {

	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		String authorId		= rs.getString("AUTHOR_ID");
		String authorName	= rs.getString("AUTHOR_NAME");
		String authorAbout	= rs.getString("AUTHOR_ABOUT");
		return new Author(authorId, authorName, authorAbout);
	}

}
