package com.book.store.demo;
// Đây là DF

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.book.store.query.SqlLoader;
import com.ibm.adf.query.execute.Jdbc;

@Repository
public class Dbook extends ConfigDataSource {
	
	@Autowired
	private JdbcTemplate jdbc;
	private SqlLoader loader = SqlLoader.getInstance();

	public List<Book00VO> s000(Book00VO vo) {
		String query = "BOOKS.s000";
		Object[] params = new Object[] {vo.getBookId()};
		BookDetailMapper mapper = new BookDetailMapper();
		System.out.println("loader.getSql(query): "+loader.getSql(query));
		System.out.println("params: " + params.toString());
		System.out.println("mapper: " + mapper);
		System.out.println("jdbc: " + jdbc);
		return jdbc.query(loader.getSql(query), params, mapper);
	}

	private class BookDetailMapper implements RowMapper<Book00VO> {

		@Override
		public Book00VO mapRow(ResultSet rs, int rowNum) throws SQLException {
			String tempString = "";
			Book00VO returnVO = new Book00VO();
			tempString = rs.getString("BOOK_ID");
			returnVO.setBookId(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_TITLE");
			returnVO.setBookTitle(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_DESCRIPTION");
			returnVO.setBookDescription(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_EDITION");
			returnVO.setBookEdition(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_FORMAT");
			returnVO.setBookFormat(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_ISBN");
			returnVO.setBookIsbn(tempString == null ? null : tempString.trim());
			tempString = rs.getString("BOOK_PAGE");
			returnVO.setBookPage(tempString == null ? null : tempString.trim());
			tempString = rs.getString("POST_DATE");
			returnVO.setPostDate(tempString == null ? null : tempString.trim());
			tempString = rs.getString("AUTHOR_ID");
			returnVO.setAuthorId(tempString == null ? null : tempString.trim());
			tempString = rs.getString("AUTHOR_NAME");
			returnVO.setAuthorName(tempString == null ? null : tempString.trim());
			tempString = rs.getString("AUTHOR_ABOUT");
			returnVO.setAuthorAbout(tempString == null ? null : tempString.trim());
			tempString = rs.getString("IMAGE_CLOUD");
			returnVO.setImageCloud(tempString == null ? null : tempString.trim());
			tempString = rs.getString("CATEGORY_ID");
			returnVO.setCategoryId(tempString == null ? null : tempString.trim());
			tempString = rs.getString("LINK_URL");
			returnVO.setLinkUrl(tempString == null ? null : tempString.trim());

			return returnVO;
		}

	}
}
