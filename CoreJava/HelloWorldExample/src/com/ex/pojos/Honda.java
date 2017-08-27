package com.ex.pojos;

import static java.lang.Math.sqrt;

import java.io.Serializable;

import com.ex.vehicles.Car;

public class Honda extends Car implements Serializable{
	public int h = 100;
	private String model;
	private int mpg;
	private String description;
	
	public Honda(){
		System.out.println("in honda constructor");
	}
	
	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
		this.description = description;
		System.out.println("in honda constructor");
	}
	
	
	/*
	 * Encapsulation (data hiding)
	 * getters and setters:
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
	
	public int getH(){
		return h;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	/*
	 * Driveable methods:
	 */
	
	
	public void steer() {
		System.out.println("steering");
	}
	
	public void start() {
		System.out.println("starting");
	}
	
	//overriding stop method
	
//	public double stop(double mph) {
//		double seconds = sqrt(mph);
//		System.out.print("Honda is stopping");
//		//basic for loop
//		
//		for(double i = mph; i > 0; i--){
//			System.out.println(i + " ");
//		}
//	
//		return seconds/2;
//	}
	
	public double stop(double mph) {
		double seconds = sqrt(mph);
		System.out.println(h);
		return seconds/2;
	}
	
	
	//overloading
	public void stop(){
		System.out.println("stop");
	}
	
	public void doHondaThings(){
		System.out.println("hey im a honda");
	}
	


}
