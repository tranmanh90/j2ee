package com.book.store.vo;

import com.book.store.BaseVO;

public class Category00VO extends BaseVO {
	
	private String categoryId;
	private String categoryName;
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category00VO [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}


