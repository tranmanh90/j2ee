package com.book.store.query;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sqlList")
public class SqlList {
	private List<SqlPaths> listPaths;

	@XmlElement(name = "sql")
	public List<SqlPaths> getListPaths() {
		return listPaths;
	}

	public void setListPaths(List<SqlPaths> listPaths) {
		this.listPaths = listPaths;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SqlList [listPaths=");
		builder.append(listPaths);
		builder.append("]");
		return builder.toString();
	}

}
