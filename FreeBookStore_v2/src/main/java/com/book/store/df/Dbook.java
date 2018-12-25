package com.book.store.df;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.book.store.config.ConfigDataSource;
import com.book.store.query.SqlLoader;
import com.book.store.vo.Book00VO;
import com.book.store.vo.Book01VO;
import com.book.store.vo.Book02VO;

/**************************************************************
 * <pre>
 *  
* Book DF
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Dbook {

	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private JdbcTemplate jdbc = new JdbcTemplate(ConfigDataSource.getDataSource());
	private SqlLoader loader = SqlLoader.getInstance();

	/**************************************************************
	 * <pre>
	* Search book by title
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return A list of searched books
	 *************************************************************/
	public List<Book00VO> s000(Book00VO vo) {
		String methodName = "s000";
		logger.info(className + ": " + methodName);
		String query = "BOOKS.s000";
		Object[] pMapper = new Object[] { vo.getPage(), vo.getRowPerPage(), vo.getBookTitle() };

		RowMapper<Book00VO> rMapper = new RowMapper<Book00VO>() {
			@Override
			public Book00VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String tempString = "";
				Book00VO returnVO = new Book00VO();

				returnVO.setTotalPages(rs.getInt("TOTAL_PAGES"));
				returnVO.setTotalRows(rs.getInt("TOTAL_ROWS"));
				returnVO.setPage(rs.getInt("PAGE_INDEX"));

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
		};
		return jdbc.query(loader.getSql(query), pMapper, rMapper);
	}

	/**************************************************************
	 * <pre>
	* Search book by ID
	 * </pre>
	 * 
	 * @param vo Request data from client
	 * @return A book with the corresponding ID
	 *************************************************************/
	public List<Book01VO> s001(Book01VO vo) {
		String methodName = "s001";
		logger.info(className + ": " + methodName);
		String query = "BOOKS.s001";
		Object[] pMapper = new Object[] { vo.getPage(), vo.getRowPerPage(), vo.getBookId() };

		RowMapper<Book01VO> rMapper = new RowMapper<Book01VO>() {
			@Override
			public Book01VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String tempString = "";
				Book01VO returnVO = new Book01VO();

				returnVO.setTotalPages(rs.getInt("TOTAL_PAGES"));
				returnVO.setTotalRows(rs.getInt("TOTAL_ROWS"));
				returnVO.setPage(rs.getInt("PAGE_INDEX"));

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
		};
		return jdbc.query(loader.getSql(query), pMapper, rMapper);
	}

	/**************************************************************
	 * <pre>
	* Search book by author ID
	 * </pre>
	 * 
	 * @param vo Request data from client
	 * @return A book with the corresponding ID
	 *************************************************************/
	public List<Book02VO> s002(Book02VO vo) {
		String methodName = "s002";
		logger.info(className + ": " + methodName);
		String query = "BOOKS.s002";
		Object[] pMapper = new Object[] { vo.getPage(), vo.getRowPerPage(), vo.getAuthorId() };

		RowMapper<Book02VO> rMapper = new RowMapper<Book02VO>() {
			@Override
			public Book02VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String tempString = "";
				Book02VO returnVO = new Book02VO();

				returnVO.setTotalPages(rs.getInt("TOTAL_PAGES"));
				returnVO.setTotalRows(rs.getInt("TOTAL_ROWS"));
				returnVO.setPage(rs.getInt("PAGE_INDEX"));

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
		};
		return jdbc.query(loader.getSql(query), pMapper, rMapper);
	}

}
