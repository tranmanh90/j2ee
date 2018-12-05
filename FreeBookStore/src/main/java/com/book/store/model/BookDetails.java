package com.book.store.model;

import java.util.List;

public class BookDetails {
	private List<Book> books;
	private String responseMessage;
	private String responseCode;

	public List<Book> getBooks() {
		return books;
	}

	public BookDetails(List<Book> books, String responseCode,String responseMessage) {
		super();
		this.books = books;
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
		
	}
	
	public BookDetails(String responseCode, String responseMessage) {
		super();
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookDetails [books=");
		builder.append(books);
		builder.append(", responseMessage=");
		builder.append(responseMessage);
		builder.append(", responseCode=");
		builder.append(responseCode);
		builder.append("]");
		return builder.toString();
	}

}
