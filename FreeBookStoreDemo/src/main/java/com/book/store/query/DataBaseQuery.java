package com.book.store.query;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dbQuery")
public class DataBaseQuery {
	private List<SqlSelect> selectSql;
	private List<SqlInsert> insertSql;
	private List<SqlUpdate> updateSql;
	private List<SqlDelete> deleteSql;

	@XmlElement(name = "select")
	public List<SqlSelect> getSelectSql() {
		return selectSql;
	}

	public void setSelectSql(List<SqlSelect> selectSql) {
		this.selectSql = selectSql;
	}

	@XmlElement(name = "insert")
	public List<SqlInsert> getInsertSql() {
		return insertSql;
	}

	public void setInsertSql(List<SqlInsert> insertSql) {
		this.insertSql = insertSql;
	}

	@XmlElement(name = "update")
	public List<SqlUpdate> getUpdateSql() {
		return updateSql;
	}

	public void setUpdateSql(List<SqlUpdate> updateSql) {
		this.updateSql = updateSql;
	}

	@XmlElement(name = "delete")
	public List<SqlDelete> getDeleteSql() {
		return deleteSql;
	}

	public void setDeleteSql(List<SqlDelete> deleteSql) {
		this.deleteSql = deleteSql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataBaseQuery [selectSql=");
		builder.append(selectSql);
		builder.append(", insertSql=");
		builder.append(insertSql);
		builder.append(", updateSql=");
		builder.append(updateSql);
		builder.append(", deleteSql=");
		builder.append(deleteSql);
		builder.append("]");
		return builder.toString();
	}

}