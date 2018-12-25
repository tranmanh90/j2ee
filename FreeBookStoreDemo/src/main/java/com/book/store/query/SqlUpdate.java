package com.book.store.query;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "update")
public class SqlUpdate {
	private String updateId;
	private String updateSql;

	public SqlUpdate() {
	}

	public SqlUpdate(String updateId, String updateSql) {
		this.updateId = updateId;
		this.updateSql = updateSql;
	}

	@XmlAttribute(name = "id")
	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	@XmlValue
	public String getUpdateSql() {
		return updateSql;
	}

	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SqlUpdate [updateId=");
		builder.append(updateId);
		builder.append(", updateSql=");
		builder.append(updateSql);
		builder.append("]");
		return builder.toString();
	}

}
