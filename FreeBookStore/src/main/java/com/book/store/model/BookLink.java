package com.book.store.model;

public class BookLink {
	private String bookId;
	private String linkId;

	public BookLink(String bookId, String linkId) {
		super();
		this.bookId = bookId;
		this.linkId = linkId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookLink [bookId=");
		builder.append(bookId);
		builder.append(", linkId=");
		builder.append(linkId);
		builder.append("]");
		return builder.toString();
	}

}
