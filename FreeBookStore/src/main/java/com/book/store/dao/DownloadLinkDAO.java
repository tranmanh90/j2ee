package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.DownloadLinkMapper;
import com.book.store.model.DownloadLink;

@Repository
public class DownloadLinkDAO extends JdbcDaoSupport {
	private static final String BASE_DOWNLOAD_LINK_SQL = "SELECT DL.LINK_ID, DL.LINK_URL FROM DOWNLAOD_LINKS DL";

	@Autowired
	public DownloadLinkDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public DownloadLink getDownloadLink(String linkId) {
		String sql = BASE_DOWNLOAD_LINK_SQL + " WHERE DL.LINK_ID = ?";
		Object[] params = new Object[] { linkId };
		DownloadLinkMapper mapper = new DownloadLinkMapper();
		try {
			DownloadLink downloadLink = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return downloadLink;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<DownloadLink> getListDownloadLinks() {
		String sql = BASE_DOWNLOAD_LINK_SQL;
		Object[] params = new Object[] {};
		DownloadLinkMapper mapper = new DownloadLinkMapper();
		List<DownloadLink> listDownloadLinks = this.getJdbcTemplate().query(sql, params, mapper);
		return listDownloadLinks;
	}
}
