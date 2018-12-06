package com.book.store.model;

public class BookCategory {
	private String id;
	private String bookId;
	private String categoryId;

	public BookCategory(String id, String bookId, String categoryId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.categoryId = categoryId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		builder.append("BookCategory [id=");
		builder.append(id);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append("]");
		return builder.toString();
	}

}
