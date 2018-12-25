package com.book.store.dto;

import java.util.Arrays;

import com.book.store.BaseRespone;

/**************************************************************
 * <pre>
* Search author by name response entity
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Author01Response extends BaseRespone {
	private int page;
	private int totalRows;
	private int totalPages;

	private Author01Dto[] author;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public Author01Dto[] getAuthor() {
		return author;
	}

	public void setAuthor(Author01Dto[] author) {
		this.author = author;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author01Response [page=");
		builder.append(page);
		builder.append(", totalRows=");
		builder.append(totalRows);
		builder.append(", totalPages=");
		builder.append(totalPages);
		builder.append(", author=");
		builder.append(Arrays.toString(author));
		builder.append("]");
		return builder.toString();
	}

}
