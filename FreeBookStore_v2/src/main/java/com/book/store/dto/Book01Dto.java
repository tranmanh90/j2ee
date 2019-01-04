package com.book.store.dto;

import java.util.Arrays;

/**************************************************************
 * <pre>
* Search book by id dto
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Book01Dto {
	private String bookId;
	private String bookTitle;
	private String bookDescription;
	private String bookPage;
	private String bookFormat;
	private String bookEdition;
	private String bookIsbn;
	private String postDate;
	private Author01Dto[] authors;
	private String imageCloud;
	private Category00Dto category;
	private String linkUrl;

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

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public Author01Dto[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author01Dto[] authors) {
		this.authors = authors;
	}

	public String getImageCloud() {
		return imageCloud;
	}

	public void setImageCloud(String imageCloud) {
		this.imageCloud = imageCloud;
	}

	public Category00Dto getCategory() {
		return category;
	}

	public void setCategory(Category00Dto category) {
		this.category = category;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book01Dto [bookId=");
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
		builder.append(", bookIsbn=");
		builder.append(bookIsbn);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", authors=");
		builder.append(Arrays.toString(authors));
		builder.append(", imageCloud=");
		builder.append(imageCloud);
		builder.append(", category=");
		builder.append(category);
		builder.append(", linkUrl=");
		builder.append(linkUrl);
		builder.append("]");
		return builder.toString();
	}

}
