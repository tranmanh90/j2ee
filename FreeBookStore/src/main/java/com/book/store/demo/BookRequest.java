package com.book.store.demo;

public class BookRequest extends BaseRequest {
	private String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookRequest [bookId=");
		builder.append(bookId);
		builder.append("]");
		return builder.toString();
	}

}
