package com.book.store.model;

public class BookAuthor {
	private String id;
	private String bookId;
	private String authorId;

	public BookAuthor() {
		super();
	}

	public BookAuthor(String id, String bookId, String authorId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.authorId = authorId;
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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookAuthor [id=");
		builder.append(id);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append("]");
		return builder.toString();
	}

}
