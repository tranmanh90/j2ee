package com.book.store.dto;

/**************************************************************
 * <pre>
* Search author by name dto
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Author00Dto {
	private String authorId;
	private String authorName;
	private String authorAbout;

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
		builder.append("Author00Dto [authorId=");
		builder.append(authorId);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append(", authorAbout=");
		builder.append(authorAbout);
		builder.append("]");
		return builder.toString();
	}

}
