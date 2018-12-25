package com.book.store.query;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "delete")
public class SqlDelete {
	private String deleteId;
	private String deleteSql;

	public SqlDelete() {
	}

	public SqlDelete(String deleteId, String deleteSql) {
		this.deleteId = deleteId;
		this.deleteSql = deleteSql;
	}

	@XmlAttribute(name = "id")
	public String getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

	@XmlValue
	public String getDeleteSql() {
		return deleteSql;
	}

	public void setDeleteSql(String deleteSql) {
		this.deleteSql = deleteSql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SqlDelete [deleteId=");
		builder.append(deleteId);
		builder.append(", deleteSql=");
		builder.append(deleteSql);
		builder.append("]");
		return builder.toString();
	}

}
