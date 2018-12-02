package com.book.store.model;

import java.util.List;

public class BookDetails {
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
	
	

	public BookDetails(List<Book> books) {
		super();
		this.books = books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookDetails [books=");
		builder.append(books);
		builder.append("]");
		return builder.toString();
	}

}
