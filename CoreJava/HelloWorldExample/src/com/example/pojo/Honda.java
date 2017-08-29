package com.example.pojo;

public class Honda extends Car {
	private String model;
	private int mpg;
	private String description;
	
	public Honda() {}
	
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
	
	public void steer() {
		System.out.println();
	}
	
	public void start() {
		System.out.println();
	}
	
	public double stop(double mph) {
		double sec = Math.sqrt(mph);
		System.out.println("Honda is stopping");
		
		for (double i = mph; i > 0; i--) {
			System.out.println(i + " ");
		}
		
		return sec/2;
	}
}
