package com.book.store.dto;

import java.util.Arrays;

import com.book.store.BaseRespone;

/**************************************************************
 * <pre>
* Search book by category id response entity
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Book03Response extends BaseRespone {

	private int page;
	private int totalRows;
	private int totalPages;
	private Book03Dto[] listBooks;

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

	public Book03Dto[] getListBooks() {
		return listBooks;
	}

	public void setListBooks(Book03Dto[] listBooks) {
		this.listBooks = listBooks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book03Response [page=");
		builder.append(page);
		builder.append(", totalRows=");
		builder.append(totalRows);
		builder.append(", totalPages=");
		builder.append(totalPages);
		builder.append(", listBooks=");
		builder.append(Arrays.toString(listBooks));
		builder.append("]");
		return builder.toString();
	}

}
