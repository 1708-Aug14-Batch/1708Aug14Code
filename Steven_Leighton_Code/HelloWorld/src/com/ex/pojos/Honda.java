package com.ex.pojos;

import com.ex.vehicles.Car;

public class Honda extends Car{
	
	private int wheels;
	private int mpg;
	private String color;
	private String model;
	private String description;
	
	public Honda(){}
	
	public Honda(int wheels, int mpg, String color, String model, String description) {
		super();
		this.wheels = wheels;
		this.mpg = mpg;
		this.color = color;
		this.model = model;
		this.description = description;
	}
	
	
	/*
	 * Encapsulation (data hiding)
	 * getters/setters
	 */
	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getMpg() {
		return mpg;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public void steer() {
		System.out.println("Steering");
		
	}
	
	public void start() {
		System.out.println("Starting");
		
	}
	
	@Override
	public double stop(double mph){
		double seconds = Math.sqrt(mph);
		System.out.println("Honda is stopping");
		
		for(double i = mph; i >= 0; i--){
			System.out.println(i + " ");
		}
		return mph/2;
	}
	
}
