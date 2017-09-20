package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private String name;
	
	public Department() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
