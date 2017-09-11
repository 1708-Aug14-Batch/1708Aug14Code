package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.*;

public abstract class Car implements Driveable {
// abstraction and inheritance 
	
	//instance variables - constitute the state of an obect
	public int h = 5;

	public Car(){
		System.out.println("in Car constructor");
	}
	
	/*
	 * behavior - all the methods that are 
	 */
	public double stop(double mph) {
		double seconds = sqrt(mph);
		System.out.println(h);
		return seconds/2;
	}


	
	
	
	

}
