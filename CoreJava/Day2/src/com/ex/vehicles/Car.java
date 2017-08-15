package com.ex.vehicles;

import com.ex.interfaces.Drivable;
import static java.lang.Math.*;


public abstract class Car implements Drivable{
//abstraction and inheritance
	
	public double stop(double mph){
		double seconds = Math.sqrt(mph);
		return seconds/2;
				
	}
	

}
