package com.book.store.demo;

// Đây là DTO
// Là bộ container chứa dữ liệu, để chung chuyển dữ liệu giữa các tầng
// dto chứa các thuộc tính không chứa business logic, dùng để vận chuyển dữ liệu rất hiệu quả
// Đóng gói dữ liệu để chung chuyển giữa các tầng
// dto là dữ liệu muốn gửi đi để hiển thị trên UI,
public class BookDto {
	private String bookId;
	private String bookTitle;
	private String bookDescription;
	private String bookPage;
	private String bookFormat;
	private String bookEdition;
	private String bookIsbn;
	private String postDate;
	private String authorId;
	private String authorName;
	private String authorAbout;
	private String imageCloud;
	private String categoryId;
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

	public String getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorAbout() {
		return authorAbout;
	}

	public void setAuthorAbout(String authorAbout) {
		this.authorAbout = authorAbout;
	}

	public String getImageCloud() {
		return imageCloud;
	}

	public void setImageCloud(String imageCloud) {
		this.imageCloud = imageCloud;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
		builder.append("BookDto [bookId=");
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
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append(", authorAbout=");
		builder.append(authorAbout);
		builder.append(", imageCloud=");
		builder.append(imageCloud);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", linkUrl=");
		builder.append(linkUrl);
		builder.append("]");
		return builder.toString();
	}
}
