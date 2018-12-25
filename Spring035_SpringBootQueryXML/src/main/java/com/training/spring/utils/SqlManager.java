package com.training.spring.utils;

import java.util.Dictionary;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

public class SqlManager extends DefaultHandler {
	private Dictionary<String, String> Queries;
	private static SqlManager sqlManager = null;

	protected SqlManager() {

	}
	
	public static SqlManager create() {
		if(sqlManager == null) {
			sqlManager = new SqlManager();
		}
		return sqlManager;
	}
	
//	public void loadSqlFile() {
//		String fileName = 
//	}
	
	private List<DbQuery> listDbQuery = null;
	
}
