package com.book.store.dto;

import com.book.store.BaseRequest;

/**************************************************************
 * <pre>
* Search book by title request entity
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Book00Request extends BaseRequest {

	private int page;
	private int rowPerPage;
	private String bookTitle;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
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
		builder.append("Book00Request [page=");
		builder.append(page);
		builder.append(", rowPerPage=");
		builder.append(rowPerPage);
		builder.append(", bookTitle=");
		builder.append(bookTitle);
		builder.append("]");
		return builder.toString();
	}

}
