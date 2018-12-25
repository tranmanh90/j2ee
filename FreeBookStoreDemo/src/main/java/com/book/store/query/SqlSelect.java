package com.book.store.query;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "select")
public class SqlSelect {
	private String selectId;
	private String selectSql;

	public SqlSelect() {
	}

	public SqlSelect(String selectId, String selectSql) {
		this.selectId = selectId;
		this.selectSql = selectSql;
	}

	@XmlAttribute(name = "id")
	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	@XmlValue
	public String getSelectSql() {
		return selectSql;
	}

	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[selectId=");
		builder.append(selectId);
		builder.append(", selectSql=");
		builder.append(selectSql);
		builder.append("]");
		return builder.toString();
	}

}
