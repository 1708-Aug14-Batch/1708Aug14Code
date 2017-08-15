package com.ex.Main;

public class Shirt {
	private String brand;
	public String material;
	private double cost;
	private String store;
	
	Shirt(){
		super();
		
	}
	/*
	 * These lines after the comment represent encapsulation
	 * i.e. the getter and setter methods taking in data and storing it within
	 *  the class
	 */
	public Shirt(String brand, String material, double cost, String store) {
		super();
		this.brand = brand;
		this.material = material;
		this.cost = cost;
		this.store = store;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
	
	

}
