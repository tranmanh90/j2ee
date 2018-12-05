package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.CoverImageMapper;
import com.book.store.model.CoverImage;

@Repository
public class CoverImageDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT CI.IMAGE_ID, CI.IMAGE_PATH, CI.IMAGE_NAME, CI.IMAGE_FORMAT, CI.IMAGE_URL_ID FROM COVER_IMAGES CI";

	@Autowired
	public CoverImageDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// Read (GET method)
	public CoverImage getCoverImageByUrlId(String urlId) {
		String sql = BASE_SQL + " WHERE CI.IMAGE_URL_ID = ?";
		Object[] params = new Object[] { urlId };
		CoverImageMapper mapper = new CoverImageMapper();
		try {
			CoverImage coverImage = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return coverImage;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public CoverImage getCoverImageByImageId(String imageId) {
		String sql = BASE_SQL + " WHERE CI.IMAGE_ID = ?";
		Object[] params = new Object[] { imageId };
		CoverImageMapper mapper = new CoverImageMapper();
		try {
			CoverImage coverImage = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return coverImage;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<CoverImage> getListCoverImage() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		CoverImageMapper mapper = new CoverImageMapper();
		List<CoverImage> listImages = this.getJdbcTemplate().query(sql, params, mapper);
		return listImages;
	}

	// Update (PUT method)

	// Create (POST method)

	// Delete (DELETE method)
}
