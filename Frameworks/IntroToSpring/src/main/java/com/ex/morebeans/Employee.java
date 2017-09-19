package com.ex.morebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Stereotype Annotations:
 * @Component - used for any bean
 * @Service - Business logic layer. Does not stand for a web service!
 * @Repository - DAO layer 
 */

@Component
public class Employee {
	
	private String name;
	
	@Autowired
	private Department department;

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
