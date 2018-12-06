package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		String categoryId = rs.getString("CATEGORY_ID");
		String categoryName = rs.getString("CATEGORY_NAME");
		return new Category(categoryId, categoryName);
	}

}
