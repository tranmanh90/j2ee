package com.book.store.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.book.store.model.DownloadLink;

public class DownloadLinkMapper implements RowMapper<DownloadLink> {

	@Override
	public DownloadLink mapRow(ResultSet rs, int rowNum) throws SQLException {
		String linkId = rs.getString("LINK_ID");
		String linkUrl = rs.getString("LINK_URL");
		return new DownloadLink(linkId, linkUrl);
	}

}
