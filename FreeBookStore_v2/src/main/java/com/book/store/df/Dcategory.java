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
import com.book.store.vo.Category00VO;

public class Dcategory {
	
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
	public List<Category00VO> s000(Category00VO vo) {
		String methodName = "s000";
		logger.info(className + ": " + methodName);
		String query = "CATEGORY.s000";

		Object[] pMapper = new Object[] { vo.getCategoryId() };

		RowMapper<Category00VO> rMapper = new RowMapper<Category00VO>() {

			@Override
			public Category00VO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String tempString = "";
				Category00VO returnVO = new Category00VO();

				tempString = rs.getString("CATEGORY_ID");
				returnVO.setCategoryId(tempString == null ? null : tempString.trim());
				tempString = rs.getString("CATEGORY_NAME");
				returnVO.setCategoryName(tempString == null ? null : tempString.trim());

				return returnVO;
			}
		};
		return jdbc.query(loader.getSql(query), pMapper, rMapper);
	}
}
