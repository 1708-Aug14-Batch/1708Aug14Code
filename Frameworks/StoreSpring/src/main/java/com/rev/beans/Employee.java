package com.rev.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name;
	
	@Autowired
	private Department department;

	
	public Employee() {
		super();
	}



	public Employee(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}
	
	

	public Employee(Department department) {
		super();
		this.department = department;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
