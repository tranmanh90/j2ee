package com.training.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.mapper.AppUserMapper;
import com.training.spring.model.AppUser;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {
	@Autowired
	public AppUserDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public AppUser findUserAccount(String userName) {
		String sql = AppUserMapper.BASE_SQL + " where u.User_Name = ? ";
		Object[] params = new Object[] { userName };
		AppUserMapper mapper = new AppUserMapper();
		try {
			AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
