package com.ex.vehicles;

import com.ex.interfaces.Drivable;

public abstract class Car implements Drivable {

	@Override
	public double stop(double mph) {
		// TODO Auto-generated method stub
		double seconds = Math.sqrt(mph);
		return seconds/2;
	}


	
	
}
