package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.CategoryMapper;
import com.book.store.model.Category;

@Repository
public class CategoryDAO extends JdbcDaoSupport {

	private static final String BASE_SQL = "SELECT CT.CATEGORY_ID, CT.CATEGORY_NAME FROM CATEGORIES CT";

	@Autowired
	public CategoryDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public Category getCategory(String categoryId) {
		String sql = BASE_SQL + " WHERE CT.CATEGORY_ID = ?";
		Object[] params = new Object[] { categoryId };
		CategoryMapper mapper = new CategoryMapper();
		try {
			Category category = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return category;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Category> getListCategory() {
		String sql = BASE_SQL + " WHERE CT.CATEGORY_ID = ?";
		Object[] params = new Object[] {};
		CategoryMapper mapper = new CategoryMapper();
		List<Category> listCategory = this.getJdbcTemplate().query(sql, params, mapper);
		return listCategory;
	}
}
