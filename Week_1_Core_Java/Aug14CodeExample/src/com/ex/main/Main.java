package com.ex.main;


/*
 * Importing the Calculations interface
 * as well as the Circle class and the Shape class
 */
import com.ex.interfaces.Calculations;
import com.ex.shapes.Circle;
import com.ex.shapes.Shape;

public class Main {

	public static void main(String[] args) { //The main function
		
		Circle a = new Circle(25); //Created a Circle object with the radius of 25
		Shape b = new Circle(); //Used Polymorphism to create a new Circle from Shape. This is called a Covarient.
		
		/*
		 * The following outputs the radius, area, and perimeter of Circle a. For each output I called the getter from Circle.
		 */
		System.out.println("Circle radius: " + a.getRadius()
					   + "\nCircle area: " + a.calcArea(a.getRadius())
					   + "\nCircle perimeter: " + a.calcPerimeter(a.getRadius()));

		/*
		 * The following outputs the radius, area, and perimeter from Shape b. For the calcArea and calcPerimeter functions I fed it a value of 30.
		 */
		
		System.out.println("\nCircle radius: " + "30"
		   + "\nCircle area: " + b.calcArea(30)
		   + "\nCircle perimeter: " + b.calcPerimeter(30));
		
	}

}
