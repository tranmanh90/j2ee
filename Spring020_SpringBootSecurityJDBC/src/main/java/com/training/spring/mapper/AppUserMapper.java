package com.training.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.spring.model.AppUser;

public class AppUserMapper implements RowMapper<AppUser> {

	public static final String BASE_SQL = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u ";

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long userId = rs.getLong("user_id");
		String userName = rs.getString("user_name");
		String encrytedPassword = rs.getString("encryted_password");
		return new AppUser(userId, userName, encrytedPassword);
	}

}
