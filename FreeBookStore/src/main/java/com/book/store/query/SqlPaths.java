package com.book.store.query;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sql")
public class SqlPaths {
	private String resource;

	@XmlAttribute(name = "resource")
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SqlPaths [resource=");
		builder.append(resource);
		builder.append("]");
		return builder.toString();
	}

}
