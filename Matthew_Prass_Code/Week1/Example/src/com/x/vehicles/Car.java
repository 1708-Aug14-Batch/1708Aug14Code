package com.x.vehicles;

import exampleInterfaces.Drivable;
import static java.lang.Math.*;

public abstract class Car implements Drivable 
{
	public int h = 5;
	public double stop(double mph)
	{
		double seconds = sqrt((mph));
		System.out.println("lalal");
		return seconds/2;
		
	}
}
