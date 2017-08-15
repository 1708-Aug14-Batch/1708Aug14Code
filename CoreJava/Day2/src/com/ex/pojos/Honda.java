package com.ex.pojos;

import java.io.Serializable;

import com.ex.vehicles.Car;

public class Honda extends Car implements Serializable{
	private String model;
	private int mpg;
	private String description;
	
	public Honda(){}
	
	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public void steer() {
		System.out.println("steering");
	}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	//overloading stop method
	public double stop(double mph){
		double seconds = Math.sqrt(mph);
		System.out.println("Honda is stopping in ");
		for(double i=mph; i> 0; i--){
		System.out.print(i+" ");
		}
		return seconds/2;
				
	}
	
	

}
