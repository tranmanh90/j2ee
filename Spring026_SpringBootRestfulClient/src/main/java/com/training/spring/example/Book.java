package com.training.spring.example;

public class Book {
	private String page;
	private String rowPerPage;
	private String bookTitle;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(String rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [page=");
		builder.append(page);
		builder.append(", rowPerPage=");
		builder.append(rowPerPage);
		builder.append(", bookTitle=");
		builder.append(bookTitle);
		builder.append("]");
		return builder.toString();
	}

}
