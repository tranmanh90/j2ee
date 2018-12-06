package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.BookImageUrl;

public class BookImageUrlMapper implements RowMapper<BookImageUrl> {

	@Override
	public BookImageUrl mapRow(ResultSet rs, int rowNum) throws SQLException {
		String imageId = rs.getString("IMAGE_ID");
		String coverImage = rs.getString("IMAGE_URL");
		return new BookImageUrl(imageId, coverImage);
	}

}
