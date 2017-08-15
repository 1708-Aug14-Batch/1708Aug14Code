package com.ex.shapes;


/*
 * Imported the calculations interface
 * Also brought in Java.lang to be able to use Math for Pi and Power
 */
import com.ex.interfaces.Calculations;
import java.lang.*;

public class Shape implements Calculations  { //Implements the Calculations interface


	@Override //Overrides the calcArea function with the Polymorphism principal
	public double calcArea(double radius) { //The public calcArea function that has an argument of a double radius
		
		return Math.PI * (Math.pow(radius, 2)); //Returns the area of the circle
	}

	@Override //Overrides the calcArea function with the Polymorphism principal
	public double calcPerimeter(double radius) { //The public calcPerimeter function that also uses double radius as an argument
		
		return 2 * Math.PI * radius; //Returns the perimeter of the circle
	}
	
	
	
}
