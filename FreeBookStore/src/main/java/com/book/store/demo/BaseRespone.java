package com.book.store.demo;

public class BaseRespone {
	private String rspMsg;
	private String rspCd;

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public String getRspCd() {
		return rspCd;
	}

	public void setRspCd(String rspCd) {
		this.rspCd = rspCd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseRequest [rspMsg=");
		builder.append(rspMsg);
		builder.append(", rspCd=");
		builder.append(rspCd);
		builder.append("]");
		return builder.toString();
	}
}
