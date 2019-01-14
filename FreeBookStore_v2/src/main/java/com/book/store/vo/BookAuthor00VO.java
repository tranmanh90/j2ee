package com.book.store.vo;

import com.book.store.BaseVO;

/**************************************************************
 * <pre>
* Search author by book ID VO
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class BookAuthor00VO extends BaseVO {
	private String bookId;
	private String authorId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookAuthor00VO [bookId=");
		builder.append(bookId);
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append("]");
		return builder.toString();
	}

}
