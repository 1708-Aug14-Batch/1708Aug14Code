package com.HW.HomeWorkWeek1Day1;

//Inheritance is used here because the Hippo class extends the Animals class
public class Hippo extends Animals {

	public Hippo(int NumberOfLegs) {
		super(NumberOfLegs);
	}
	
	//This is Polymorphism, The method constructor is written twice with the same name but with different arguments.
	public Hippo(int NumberOfLegs, boolean IsHungry, int weight) {
		super(NumberOfLegs);
		this.IsHungry = IsHungry;
		this.weight = weight;
	}

	private boolean IsHungry;
	private int weight;
	
	@Override
	public void Walk() {
		System.out.println("Hippo Walks forward");
	}
	
	//PolyMorphism is used here by overriding Animals eat method so it can have it's own.
	@Override
	public void eat() {
		System.out.println("Hippos eats");
	}

	//Encapsulation is used here by not allowing the MainTest class to have access to anything within Hippo or Animals 
	//and only allows access through it's getters and setters.
	public boolean isIsHungry() {
		return IsHungry;
	}

	public void setIsHungry(boolean isHungry) {
		IsHungry = isHungry;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getLegs() {
		return NumberOfLegs;
	}
	
	public void setLegs(int LegNum) {
		NumberOfLegs = LegNum;
	}

}
