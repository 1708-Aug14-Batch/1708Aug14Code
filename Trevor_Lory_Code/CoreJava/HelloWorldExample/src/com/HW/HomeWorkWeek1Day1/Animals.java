package com.HW.HomeWorkWeek1Day1;

//Abstraction is used here by creating a abstract class that forces everything (such as the Hippo class) 
//to define and use everything abstract within it. Such as the Walk method.
public abstract class Animals {
	
	protected int NumberOfLegs;
	
	public Animals(int NumberOfLegs) {
		this.NumberOfLegs = NumberOfLegs;
	}

	public abstract void Walk();
	
	public void eat() {
		System.out.println("Generic Animal Eats");
	}
	
}
