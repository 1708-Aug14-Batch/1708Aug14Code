package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.*;

public abstract class Car implements Driveable {
//abstraction & inheritance
	public Car() {
		System.out.println("in Car constructor");
	}
	
	@Override
	public double stop(double mph) {
		// TODO Auto-generated method stub
		double seconds = sqrt(mph);
		return seconds/2;
	}
	
	
}
