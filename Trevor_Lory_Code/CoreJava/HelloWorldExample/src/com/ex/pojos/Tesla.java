package com.ex.pojos;

import com.ex.vehicles.Car;

public class Tesla extends Car{

	private String model;
	private int mpg;
	private String description;
	public int h = 100;

	//Driveable Methods
	
	@Override
	public void steer() {
		// TODO Auto-generated method stub
		System.out.println("Steering");
	}

	@Override
	public double accelerate(double mph) {
		// TODO Auto-generated method stub
		System.out.println("Accelerating");
		return mph*2;
	}
	
	public double deccelerate(double mph) {
		System.out.println("Tesla Dec");
		return 0;
	}
	
	public Tesla() { }

	public Tesla(String model, int mpg, String description) {
		this.model = model;
		this.mpg = mpg;
		this.description = description;
	}

	//Encapsulation - getters and setters
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int geth() {
		return h;
	}
	
	
	
}
