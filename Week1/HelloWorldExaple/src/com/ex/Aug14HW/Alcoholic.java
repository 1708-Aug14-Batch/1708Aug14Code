package com.ex.Aug14HW;

public class Alcoholic extends Beverage{
	private String size;
	private double amt_alc;
	
	public Alcoholic(){}
	
	public Alcoholic(String size, double amt_acl){
		super();
		this.size = size;
		this.amt_alc = amt_acl;
	}
	/*
	 * The Getters and Setters below uses the principle if encapsulation
	 */

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getAmt_alc() {
		return amt_alc;
	}

	public void setAmt_alc(double amt_alc) {
		this.amt_alc = amt_alc;
	}
	/*
	 * The method below uses the principle of polymorphism by overloading a method taking
	 * from the parent class.
	 */
	public void purchase(){
		System.out.println("The customer must be at least 21 years old to purchase this item.");
	}

}
