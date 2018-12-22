package com.book.store.query;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "insert")
public class SqlInsert {
	private String insertId;
	private String insertSql;

	public SqlInsert() {
	}

	public SqlInsert(String insertId, String insertSql) {
		this.insertId = insertId;
		this.insertSql = insertSql;
	}

	@XmlAttribute(name = "id")
	public String getInsertId() {
		return insertId;
	}

	public void setInsertId(String insertId) {
		this.insertId = insertId;
	}

	@XmlValue
	public String getInsertSql() {
		return insertSql;
	}

	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InsertSql [insertId=");
		builder.append(insertId);
		builder.append(", insertSql=");
		builder.append(insertSql);
		builder.append("]");
		return builder.toString();
	}

}
