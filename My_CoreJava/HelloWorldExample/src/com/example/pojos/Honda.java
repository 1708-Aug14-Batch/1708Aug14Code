package com.example.pojos;

import java.io.Serializable;

import com.example.vehicles.Car;

public class Honda extends Car implements Serializable {
	
	private String model;
	private int mpg;
	private String description;

	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
		this.description = description;
	}

	public void steer() {
		// TODO Auto-generated method stub
		
	}

	public void accelerate(double rate) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return model + ", " + mpg + " mpg, " + description;
	}
}
