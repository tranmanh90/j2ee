package com.training.webservice.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.training.webservice.model.Employee;

public class EmployeeDAO {
	private static final Map<String, Employee> employeeMap = new HashMap<>();

	static {
		initEmployee();
	}

	private static void initEmployee() {
		Employee employee1 = new Employee("E01", "Tran Van A", "Clerk");
		Employee employee2 = new Employee("E02", "Tran Van B", "Clerk");
		Employee employee3 = new Employee("E03", "Tran Van C", "Clerk");

		employeeMap.put(employee1.getEmployeeNumber(), employee1);
		employeeMap.put(employee2.getEmployeeNumber(), employee2);
		employeeMap.put(employee3.getEmployeeNumber(), employee3);
	}

	public static Employee getEmployee(String empNumber) {
		return employeeMap.get(empNumber);
	}

	public static Employee addEmployee(Employee emp) {
		employeeMap.put(emp.getEmployeeNumber(), emp);
		return emp;
	}

	public static Employee updateEmployee(Employee emp) {
		employeeMap.put(emp.getEmployeeNumber(), emp);
		return emp;
	}

	public static void deleteEmployee(String empNumber) {
		employeeMap.remove(empNumber);
	}

	public static List<Employee> getAllEmployee() {
		Collection<Employee> c = employeeMap.values();
		List<Employee> listEmp = new ArrayList<>();
		listEmp.addAll(c);
		return listEmp;
	}

}
