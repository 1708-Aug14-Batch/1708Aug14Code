package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.sqrt;

public abstract class Car implements Driveable {
	//Abstraction and inheritance
	public double stop(double mph) {
		double seconds = sqrt(mph);
		return seconds/2;
	}
	public int h = 5;
	public Car() {
		System.out.println("in car constructor");
	}
	
	
	@Override
	public void steer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
}
