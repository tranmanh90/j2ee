package com.book.store.model;

public class Author {
	private String authorId;
	private String authorName;
	private String authorAbout;

	public Author() {
		super();
	}

	public Author(String authorId, String authorName, String authorAbout) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorAbout = authorAbout;
	}

	public String getAuthorId() {
		return authorId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [authorId=");
		builder.append(authorId);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append(", authorAbout=");
		builder.append(authorAbout);
		builder.append("]");
		return builder.toString();
	}

}
