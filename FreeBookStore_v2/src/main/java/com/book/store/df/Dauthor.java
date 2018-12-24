package com.book.store.df;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

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
//	public List<Author00VO> s000(Author00VO vo){
//		String methodName = "s000";
//		logger.info(className + ": " + methodName);
//		String query = "AUTHORS.s000";
//	}
}
