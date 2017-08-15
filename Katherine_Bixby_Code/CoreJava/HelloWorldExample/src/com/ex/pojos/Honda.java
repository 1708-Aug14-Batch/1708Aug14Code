package com.ex.pojos;

import com.ex.vehicles.Car;


public class Honda extends Car{

	private String model;
	private int mpg;
	private String description;
	
	public Honda() {}
	
	
	public Honda(String model, int mpg, String description) {
		super();
		this.model = model;
		this.mpg = mpg;
		this.description = description;
		System.out.println("In Honda Constructor");
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
		System.out.println("steering");
		
	}

	public void start() {
		System.out.println("starting");
	}
	
	@Override
	public double stop(double mph) {
		double seconds = Math.sqrt(mph);
		System.out.println("Honda is stopping");
		for (int i=(int) mph;i>=0;i--) {
			System.out.println(i+" ");
		}
		return seconds/2;
	}
	
	public void stop() {
		System.out.println("stop");
	}
	
//	Honda h = new Honda();
//	Honda honda = new Honda("model",3452,"description");
//	
//	h.stop(50);
//	h.stop();
	
	
}
