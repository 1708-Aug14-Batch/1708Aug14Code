package com.ex.day2;

import java.io.Serializable;

public class Honda implements Serializable {
	private String description;
	private String model;
	private int mpg;
	
	public Honda() {
		super();
		this.description = description;
		this.model = model;
		this.mpg = mpg;
	}
	
	public Honda(String description, String model, int mpg) {
		super();
		this.description = description;
		this.model = model;
		this.mpg = mpg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMpg() {
		return mpg;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

}
