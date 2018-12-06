package com.book.store.model;

public class BookCategory {
	private String bookId;
	private String categoryId;

	public BookCategory(String bookId, String categoryId) {
		super();
		this.bookId = bookId;
		this.categoryId = categoryId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookCategory [bookId=");
		builder.append(bookId);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append("]");
		return builder.toString();
	}

}
