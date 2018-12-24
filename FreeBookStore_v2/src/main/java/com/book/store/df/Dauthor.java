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
import com.book.store.vo.Author00VO;

/**************************************************************
 * <pre>
* Author DF
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class Dauthor {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private JdbcTemplate jdbc = new JdbcTemplate(ConfigDataSource.getDataSource());
	private SqlLoader loader = SqlLoader.getInstance();

	/**************************************************************
	 * <pre>
	* Search author by name
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return The searched author
	 *************************************************************/
	public List<Author00VO> s000(Author00VO vo) {
		String methodName = "s000";
		logger.info(className + ": " + methodName);
		String query = "AUTHORS.s000";

		Object[] pMapper = new Object[] { vo.getPage(), vo.getRowPerPage(), vo.getAuthorName() };

		RowMapper<Author00VO> rMapper = new RowMapper<Author00VO>() {

			@Override
			public Author00VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String tempString = "";
				Author00VO returnVO = new Author00VO();

				returnVO.setTotalPages(rs.getInt("TOTAL_PAGES"));
				returnVO.setTotalRows(rs.getInt("TOTAL_ROWS"));
				returnVO.setPage(rs.getInt("PAGE_INDEX"));

				tempString = rs.getString("AUTHOR_ID");
				returnVO.setAuthorId(tempString == null ? null : tempString.trim());
				tempString = rs.getString("AUTHOR_NAME");
				returnVO.setAuthorName(tempString == null ? null : tempString.trim());
				tempString = rs.getString("AUTHOR_ABOUT");
				returnVO.setAuthorAbout(tempString == null ? null : tempString.trim());

				return returnVO;
			}
		};
		return jdbc.query(loader.getSql(query), pMapper, rMapper);
	}
}
