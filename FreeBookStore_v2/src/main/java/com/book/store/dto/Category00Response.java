package com.book.store.dto;

import com.book.store.BaseRespone;

public class Category00Response  extends BaseRespone {
	

	private Category00Dto[] catagoryList;

	public Category00Dto[] getCatagoryList() {
		return catagoryList;
	}

	public void setCatagoryList(Category00Dto[] catagoryList) {
		this.catagoryList = catagoryList;
	}
	
	
}
