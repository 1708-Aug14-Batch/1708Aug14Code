package com.ex.vehicles;

import com.ex.interfaces.Drivable;
import static java.lang.Math.*;

public abstract class Car implements Drivable {

	public Car() {
		System.out.println("In car constructor");
	}
	
	public double stop(double mph) {
		double seconds = sqrt(mph);
		return seconds/2;
	}
}
