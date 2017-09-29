package com.ex.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private String employeeName;
	
	@Autowired
	private Department department;
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
