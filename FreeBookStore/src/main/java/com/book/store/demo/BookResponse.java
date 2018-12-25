package com.book.store.demo;

import java.util.Arrays;

public class BookResponse extends BaseRespone {

	private BookDto[] grdList;

	public BookDto[] getGrdList() {
		return grdList;
	}

	public void setGrdList(BookDto[] grdList) {
		this.grdList = grdList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookResponse [grdList=");
		builder.append(Arrays.toString(grdList));
		builder.append("]");
		return builder.toString();
	}

}
