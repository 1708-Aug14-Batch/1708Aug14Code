package com.ex.newpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String name;
	@Autowired
	private Department dept;
	
	public Employee() {
		
	}
	
	public Employee(String name,Department dept) {
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDpt() {
		return dept;
	}
	public void setDpt(Department dpt) {
		this.dept = dpt;
	}
	
	

}
