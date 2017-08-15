package com.ex.pojos; //Pojo means Plain Old Java Object

import static java.lang.Math.sqrt;

import java.io.Serializable;

import com.ex.vehicles.Car;

public class Honda extends Car implements Serializable {

	private String model;
	private int mpg;
	private String description;
	public int h = 100;
	
	public Honda() {} //Implicit no-args constructor
	
	//Honda h = new Honda();
	// h.model = "hi".
	
	//Constructor
	public Honda(String model, int mpg, String description) {
		super(); //Calling the superclass. In this case its Car
		this.model = model;
		this.mpg = mpg;
		this.description = description;
		
	}
	
	/*
	 * Encapsulation (data hiding)
	 * Getters and Setters
	 */
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
		System.out.println("steering");
		
	}
	
	public void start() {
		System.out.println("starting");
		
	}
	//overriding stop method
	public double stop(double mph) {
		double seconds = sqrt(mph);
		System.out.println("Honda is stopping");
		//basic for loop
		for(double i = mph; i > 0; i--) {
			System.out.println(i+ " ");
		}
		return seconds/2;
	}
	
	//overloading
	public void stop() {
		System.out.println("Stop");
	}
	
	//Honda h = new Honda();
	//Honda f = new Honda("model", 3452, "description");
	
	
}
