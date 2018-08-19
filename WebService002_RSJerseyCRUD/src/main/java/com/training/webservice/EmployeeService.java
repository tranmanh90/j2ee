package com.training.webservice;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.training.webservice.dao.EmployeeDAO;
import com.training.webservice.model.Employee;

@Path("/employees")
public class EmployeeService {
	/* URI: /contextPath/servletPath/employees */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployeeJSON() {
		List<Employee> listOfEmp = EmployeeDAO.getAllEmployee();
		return listOfEmp;
	}

	/* URI: /contextPath/servletPath/employees/{empNo} */
	@GET
	@Path("/{empNo}/get")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployee(@PathParam("empNo") String empNo) {
		System.out.println("====================>" + empNo);
		return EmployeeDAO.getEmployee(empNo);
	}

	/* URI: /contextPath/servletPath/employees */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee updateEmployee(Employee emp) {
		return EmployeeDAO.updateEmployee(emp);
	}

	/* URI: /contextPath/servletPath/employees/delete/{empNo} */
	@DELETE
	@Path("/delete/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEmployee(@PathParam("empNo") String empNo) {
		EmployeeDAO.deleteEmployee(empNo);
	}

}
