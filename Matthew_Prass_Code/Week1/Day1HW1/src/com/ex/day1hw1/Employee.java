package com.ex.day1hw1;

//Inheritance
public class Employee extends Person{

	//Variables(Encapsulation)
	//private int step;
	private boolean isLate;
	
	
	//Constructors
	public Employee()
	{
		step = 1;
		isLate = false;
	}
	
	public Employee(int step, boolean isLate)
	{
		this.step = step;
		this.isLate = isLate;
	}
	
	
	
	//Getters and Setters(Encapsulation)
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isLate() {
		return isLate;
	}

	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}

	
	
	//Polymorphism
	public void move(int speed)
	{
		if(isLate)
			step+=(speed*2);
		else
			super.move(speed);
	}
	@Override
	public void doAThing() {
		System.out.println("Got the job!!");
	}

}
