package com.ex.shapes;

public class Circle extends Shape { //The circle class that uses Inheritance to bring in Shape

	private double radius; //The radius value used for the calculations
	
	public Circle() {} //The no-argument constructor for circle
	
	public Circle(double radius) { //The constructor
		super(); //Calling the superclass which is Shape
		this.radius = radius; //Sets the radius
	}
	
	/*
	 * Following the principal of Encapsulation, the following getter and setter sets the radius for an instantiate of the Circle object
	 */
	public double getRadius() { 
		return radius;
	}
	public void setRadius(double radius) { 
		this.radius = radius;
	}

	
}
