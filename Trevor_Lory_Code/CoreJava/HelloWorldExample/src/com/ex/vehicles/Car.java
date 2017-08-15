package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.sqrt;

public abstract class Car implements Driveable {
//abstraction and inheritance
	
	public int h = 5;
	
	public Car() {
		System.out.println("In Car Constructor");
	}
	
	public double deccelerate(double mph) {
		double seconds = sqrt(mph); //instead of Math.sqrt
		System.out.println("Car dec");
		return seconds/2;
	}

}
