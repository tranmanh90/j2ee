package com.book.store.dto;

import com.book.store.BaseRequest;

/**************************************************************
 * <pre>
* Search author by name request entity
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Author00Request extends BaseRequest {
	private int page;
	private int rowPerPage;
	private String authorName;

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author00Request [page=");
		builder.append(page);
		builder.append(", rowPerPage=");
		builder.append(rowPerPage);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append("]");
		return builder.toString();
	}

}
