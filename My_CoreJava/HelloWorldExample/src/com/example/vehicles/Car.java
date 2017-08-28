package com.example.vehicles;

import com.example.helloworld.Drivable;

public abstract class Car implements Drivable {
	
	public double stop(double mph) {
		return Math.sqrt(mph) / 2;
	}
}
