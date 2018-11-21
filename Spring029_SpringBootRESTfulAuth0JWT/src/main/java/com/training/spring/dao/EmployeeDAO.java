package com.training.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.training.spring.mapper.EmployeeMapper;
import com.training.spring.model.Employee;

@Repository
public class EmployeeDAO extends JdbcDaoSupport {
	
	public static final String BASE_SQL = "select emp.emp_no, emp.emp_name, emp.emp_position from employee emp";
	
	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// Read (GET method)
	public Employee getEmployee(String empNo) {
		String sql = "select emp.emp_no, emp.emp_name, emp.emp_position from employee emp  where emp.emp_no = ? ";
		Object[] params = new Object[] { empNo };
		EmployeeMapper mapper = new EmployeeMapper();

		try {
			Employee employee = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return employee;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
	
	public List<Employee> getEmployees() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		List<Employee> listEmp = this.getJdbcTemplate().query(sql, params, mapper);
		return listEmp;
	}

	// Update (PUT method)
	public List<Employee> updateEmployee(Employee employee) {
		String sqlupdate = "UPDATE EMPLOYEE SET EMP_NAME = '" + employee.getEmpName() + "', EMP_POSITION = '"
				+ employee.getPosition() + "' WHERE EMP_NO = '" + employee.getEmpNo() + "'";
		this.getJdbcTemplate().update(sqlupdate);

		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		List<Employee> listEmp = this.getJdbcTemplate().query(sql, params, mapper);
		return listEmp;
	}

	// Create (POST method)
	public List<Employee> createEmployee(Employee employee) {
		String sqlcreate = "INSERT INTO EMPLOYEE  VALUES('" + employee.getEmpNo() + "','" + employee.getEmpName()
				+ "','" + employee.getPosition() + "')";
		this.getJdbcTemplate().update(sqlcreate);

		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		List<Employee> listEmp = this.getJdbcTemplate().query(sql, params, mapper);
		return listEmp;
	}

	// Delete (DELETE method)
	public List<Employee> deleteEmployee(String empNo) {
		String sqldlt = "DELETE FROM EMPLOYEE WHERE EMP_NO = '" + empNo + "'";
		this.getJdbcTemplate().update(sqldlt);

		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		EmployeeMapper mapper = new EmployeeMapper();
		List<Employee> listEmp = this.getJdbcTemplate().query(sql, params, mapper);
		return listEmp;
	}
}
