package com.rev.beans;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private String name;

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
