package com.book.store.model;

import java.util.List;

public class Book {
	private String bookId;
	private String bookTitle;
	private String bookDescription;
	private String bookPage;
	private String bookFormat;
	private String bookEdition;
	private String bookISBN;
	private String postDate;
	private List<Author> authors;
	private BookImageUrl coverImage;
	private Category category;
	private DownloadLink downloadLink;

	public Book() {
		super();
	}

	public Book(String bookId, String bookTitle, String bookDescription, String bookPage, String bookFormat,
			String bookEdition, String bookISBN, String postDate) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPage = bookPage;
		this.bookFormat = bookFormat;
		this.bookEdition = bookEdition;
		this.bookISBN = bookISBN;
		this.postDate = postDate;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookPage() {
		return bookPage;
	}

	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}

	public String getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(String bookFormat) {
		this.bookFormat = bookFormat;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public BookImageUrl getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(BookImageUrl coverImage) {
		this.coverImage = coverImage;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public DownloadLink getDownloadLink() {
		return this.downloadLink;
	}

	public void setDownloadLink(DownloadLink downloadLink) {
		this.downloadLink = downloadLink;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=");
		builder.append(bookId);
		builder.append(", bookTitle=");
		builder.append(bookTitle);
		builder.append(", bookDescription=");
		builder.append(bookDescription);
		builder.append(", bookPage=");
		builder.append(bookPage);
		builder.append(", bookFormat=");
		builder.append(bookFormat);
		builder.append(", bookEdition=");
		builder.append(bookEdition);
		builder.append(", bookISBN=");
		builder.append(bookISBN);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", authors=");
		builder.append(authors);
		builder.append(", coverImage=");
		builder.append(coverImage);
		builder.append(", category=");
		builder.append(category);
		builder.append(", downloadLink=");
		builder.append(downloadLink);
		builder.append("]");
		return builder.toString();
	}

}
