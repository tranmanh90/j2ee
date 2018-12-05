package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.CoverImage;

public class CoverImageMapper implements RowMapper<CoverImage> {

	@Override
	public CoverImage mapRow(ResultSet rs, int rowNum) throws SQLException {
		String imageId = rs.getString("IMAGE_ID");
		String imagePath = rs.getString("IMAGE_PATH");
		String imageName = rs.getString("IMAGE_NAME");
		String imageFormat = rs.getString("IMAGE_FORMAT");
		String imageUrlId = rs.getString("IMAGE_URL_ID");
		return new CoverImage(imageId, imageUrlId, imagePath, imageName, imageFormat);
	}

}
