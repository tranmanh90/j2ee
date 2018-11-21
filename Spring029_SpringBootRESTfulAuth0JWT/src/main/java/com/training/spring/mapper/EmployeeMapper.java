package com.training.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.spring.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		String empNo = rs.getString("EMP_NO");
		String empName = rs.getString("EMP_NAME");
		String empPosition = rs.getString("EMP_POSITION");
		return new Employee(empNo, empName, empPosition);
	}

}
