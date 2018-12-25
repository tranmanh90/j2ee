package com.book.store.dto;

import com.book.store.BaseRequest;

/**************************************************************
 * <pre>
* Search book by author id request entity
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Book02Request extends BaseRequest {

	private int page;
	private int rowPerPage;
	private String authorId;

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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book02Request [page=");
		builder.append(page);
		builder.append(", rowPerPage=");
		builder.append(rowPerPage);
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append("]");
		return builder.toString();
	}

}
