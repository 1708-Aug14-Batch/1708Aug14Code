package com.ex.interfaces;

public interface Calculations { //The public interface Calculations

	//Using abstraction to create the calculation methods that are implemented into Shape. 
	
	
	public abstract double calcArea(double radius); //This is an abstract function called calcArea.
	
	public double calcPerimeter(double radius); //This is also an abstract function. Because its for an interface, Java knows to default it to abstract
	
}
