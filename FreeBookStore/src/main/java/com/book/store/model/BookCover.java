package com.book.store.model;

public class BookCover {
	private String id;
	private String bookId;
	private String imageId;

	public BookCover() {
		super();
	}

	public BookCover(String id, String bookId, String imageId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.imageId = imageId;
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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookCover [id=");
		builder.append(id);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", imageId=");
		builder.append(imageId);
		builder.append("]");
		return builder.toString();
	}

}
