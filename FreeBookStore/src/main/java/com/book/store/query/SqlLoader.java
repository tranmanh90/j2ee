package com.book.store.query;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class SqlLoader {

	private static SqlLoader instance = null;

	public static SqlLoader getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (SqlLoader.class) {
			if (instance == null) {
				instance = new SqlLoader();
			}
			return instance;
		}
	}

	public String getSql(String query) {
		String tableName = query.substring(0, query.indexOf('.'));
		System.out.println("tableName: " + tableName);
		String queryId = query.substring(query.indexOf('.') + 1);
		System.out.println("queryId: " + queryId);
		String file = "/sql/" + tableName + ".xml";
		System.out.println("file: " + file);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(DataBaseQuery.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			DataBaseQuery dbQuery = (DataBaseQuery) jaxbUnmarshaller.unmarshal(getLocalFile(file));
			System.out.println("queryId.substring(0): " + queryId.substring(0, 1));
			switch (queryId.substring(0, 1)) {
			case "s":
				return selectSql(dbQuery, queryId);
			case "u":
				return updateSql(dbQuery, queryId);
			case "i":
				return insertSql(dbQuery, queryId);
			case "d":
				return deleteSql(dbQuery, queryId);
			default:
				break;
			}
		} catch (JAXBException e) {
			return null;
		}
		return null;
	}

	private String selectSql(DataBaseQuery dbQuery, String queryId) {
		Map<String, String> map = new HashMap<>();
		if (dbQuery != null) {
			boolean found = dbQuery.getSelectSql().stream().anyMatch(p -> p.getSelectId().equals(queryId));
			if (found) {
				for (int i = 0; i < dbQuery.getSelectSql().size(); i++) {
					map.put(dbQuery.getSelectSql().get(i).getSelectId(), dbQuery.getSelectSql().get(i).getSelectSql());
				}
			}
		}
		return map.get(queryId);
	}

	private String insertSql(DataBaseQuery dbQuery, String queryId) {
		Map<String, String> map = new HashMap<>();
		if (dbQuery != null) {
			boolean found = dbQuery.getInsertSql().stream().anyMatch(p -> p.getInsertId().equals(queryId));
			if (found) {
				for (int i = 0; i < dbQuery.getSelectSql().size(); i++) {
					map.put(dbQuery.getInsertSql().get(i).getInsertId(), dbQuery.getInsertSql().get(i).getInsertSql());
				}
			}
		}
		return map.get(queryId);
	}

	private String deleteSql(DataBaseQuery dbQuery, String queryId) {
		Map<String, String> map = new HashMap<>();
		if (dbQuery != null) {
			boolean found = dbQuery.getDeleteSql().stream().anyMatch(p -> p.getDeleteId().equals(queryId));
			if (found) {
				for (int i = 0; i < dbQuery.getDeleteSql().size(); i++) {
					map.put(dbQuery.getDeleteSql().get(i).getDeleteId(), dbQuery.getDeleteSql().get(i).getDeleteSql());
				}
			}
		}
		return map.get(queryId);
	}

	private String updateSql(DataBaseQuery dbQuery, String queryId) {
		Map<String, String> map = new HashMap<>();
		if (dbQuery != null) {
			boolean found = dbQuery.getUpdateSql().stream().anyMatch(p -> p.getUpdateId().equals(queryId));
			if (found) {
				for (int i = 0; i < dbQuery.getUpdateSql().size(); i++) {
					map.put(dbQuery.getUpdateSql().get(i).getUpdateId(), dbQuery.getUpdateSql().get(i).getUpdateSql());
				}
			}
		}
		return map.get(queryId);
	}

	private File getLocalFile(String file) {
		URL fileUrl = getClass().getResource(file);
		return new File(fileUrl.getFile());
	}
}
