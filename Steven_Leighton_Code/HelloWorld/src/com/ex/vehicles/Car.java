package com.ex.vehicles;

import com.ex.interfaces.Driveable;

public abstract class Car implements Driveable {

	//want to start/steer differently per car, but stop stays same
	
	@Override
	public double stop(double mph) {
		
		double time = Math.sqrt(mph);
		//or do import static java.lang.Math.sqrt and you can get rid of "Math." part
		
		return time/2;
	}

}
