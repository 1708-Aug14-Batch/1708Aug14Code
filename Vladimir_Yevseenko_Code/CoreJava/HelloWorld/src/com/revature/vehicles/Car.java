package com.revature.vehicles;
import com.revature.interfaces.Driveable;
import static java.lang.Math.sqrt;

public abstract class Car implements Driveable {
	
	@Override
	public double stop(double mph) {
		return sqrt(mph) / 2;
	}
}
