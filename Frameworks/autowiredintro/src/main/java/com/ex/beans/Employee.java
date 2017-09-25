package com.ex.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* Stereotype Annotations: 
@Component - used for any bean 
@Service - business logic layer. does not stand for web service! 
@Repository - DAO layer
*/

@Component
public class Employee {
	
	private String name;
	
	@Autowired
	private Department test;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return test;
	}

	public void setDept(Department department) {
		this.test = department;
	}
	
	



}
