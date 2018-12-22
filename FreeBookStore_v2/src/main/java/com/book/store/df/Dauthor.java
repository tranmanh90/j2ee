package com.book.store.df;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.book.store.config.ConfigDataSource;
import com.book.store.query.SqlLoader;

public class Dauthor {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private JdbcTemplate jdbc = new JdbcTemplate(ConfigDataSource.getDataSource());
	private SqlLoader loader = SqlLoader.getInstance();
	
	
}
