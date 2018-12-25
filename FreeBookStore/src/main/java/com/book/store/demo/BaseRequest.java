package com.book.store.demo;

public class BaseRequest {
	private String pageNo;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseRequest [pageNo=");
		builder.append(pageNo);
		builder.append("]");
		return builder.toString();
	}

}
