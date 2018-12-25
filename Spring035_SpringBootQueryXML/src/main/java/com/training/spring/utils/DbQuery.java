package com.training.spring.utils;

public class DbQuery {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DbQuery [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
