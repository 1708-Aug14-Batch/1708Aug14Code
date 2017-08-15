package com.ex.pojos;

import static java.lang.Math.sqrt;

import java.io.Serializable;

import com.ex.vehicles.Car;

public class Honda extends Car implements Serializable{
	
	private String model;
	private int mpg;
	private String description;
	
	//Honda h = new Honda("model",8,"dededededede");
	
	public Honda() {}
	
	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
		this.description = description;
		System.out.println("something");
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void steer() {
		// TODO Auto-generated method stub
		System.out.println("steer");
		
	}
	
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("start");
		
	}

	//overriding
	public double stop(double mph) {
		double seconds = sqrt(mph);
		
		for(double i = mph; i > 0; i--) {
			System.out.println(i + " ");
		}
		
		return seconds/2;
	}
	
	//overloading
	public void stop() {
		System.out.println("stop");
	}
	
}
