package com.book.store;

import com.book.store.uf.StringUtil;

public class BaseVO {

	public static final String SPACE = " ";
	public static final int INT_ZERO = 0;

	protected int page = 1;
	protected int rowPerPage = 10;
	protected int totalPages;
	protected int totalRows;

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

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	protected int nullCheck(int value) {
		return value == 0 ? INT_ZERO : value;
	}

	protected String nullCheck(String value) {
		return (StringUtil.isEmpty(value)) ? SPACE : value;
	}
}
