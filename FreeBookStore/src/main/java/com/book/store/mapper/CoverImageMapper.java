package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.CoverImage;

public class CoverImageMapper implements RowMapper<CoverImage> {

	@Override
	public CoverImage mapRow(ResultSet rs, int rowNum) throws SQLException {
		String imageId = rs.getString("IMAGE_ID");
		String imageUrl = rs.getString("IMAGE_URL");
		String imagePath = rs.getString("IMAGE_PATH");
		String imageName = rs.getString("IMAGE_NAME");
		return new CoverImage(imageId, imageUrl, imagePath, imageName);
	}

}
