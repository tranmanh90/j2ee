package com.training.webservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	private String employeeNumber;
	private String employeeName;
	private String employeePosition;

	public Employee() {
		super();
	}

	public Employee(String employeeNumber, String employeeName, String employeePosition) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeNumber=");
		builder.append(employeeNumber);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", employeePosition=");
		builder.append(employeePosition);
		builder.append("]");
		return builder.toString();
	}

}
