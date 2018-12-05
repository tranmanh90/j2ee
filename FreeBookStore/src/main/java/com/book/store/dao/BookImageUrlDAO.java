package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.BookImageUrlMapper;
import com.book.store.model.BookImageUrl;

@Repository
public class BookImageUrlDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT CI.IMAGE_ID, CI.IMAGE_URL FROM COVER_IMAGES CI";

	@Autowired
	public BookImageUrlDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public BookImageUrl getBookImageUrl(String imageId) {
		String sql = BASE_SQL + " WHERE CI.IMAGE_ID = ?";
		Object[] params = new Object[] { imageId };
		BookImageUrlMapper mapper = new BookImageUrlMapper();
		try {
			BookImageUrl bookImageUrl = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return bookImageUrl;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<BookImageUrl> getListCoverImage() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		BookImageUrlMapper mapper = new BookImageUrlMapper();
		List<BookImageUrl> listBookImageUrls = this.getJdbcTemplate().query(sql, params, mapper);
		return listBookImageUrls;
	}
}
