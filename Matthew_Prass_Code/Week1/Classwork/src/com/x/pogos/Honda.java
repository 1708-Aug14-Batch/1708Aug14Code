package com.x.pogos;

import java.io.Serializable;

import com.x.vehicles.Car;

public class Honda extends Car implements Serializable
{
	public int h = 100;
	private String model;
	private int mpg;
	private String description;
	
	//Constructors
	public Honda()
	{
		
	}
	
	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
		this.description = description;
	}
	
	//Getters and Setters
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
	
	
	@Override
	public void steer() {
		System.out.println("Steering");
	}
	@Override
	public void start() {
		System.out.println("Starting");
	}
	
	//overriding stop method
	public double stop(double mph)
	{
		double seconds = Math.sqrt(mph);
		System.out.println("Stopping");
		for(double i = mph; i > 0; i--)
		{
			System.out.println(i + " ");
		}
		return seconds/2;
	}
	

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
