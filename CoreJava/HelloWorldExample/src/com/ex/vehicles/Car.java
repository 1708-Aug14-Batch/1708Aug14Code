package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.*;

public abstract class Car implements Driveable{

	public Car() {
		System.out.println("dede");
	}
	
	public double stop(double mph) {
		double seconds = sqrt(mph);
		System.out.println("Stopping");
		return seconds/2;
	}
	
	
	
}
