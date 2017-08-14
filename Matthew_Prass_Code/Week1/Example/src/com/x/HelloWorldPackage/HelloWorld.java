package com.x.HelloWorldPackage;

import com.x.pogos.Honda;
import com.x.vehicles.Car;

public class HelloWorld 
{
	public static void main(String[] args) 
	{
		
		//System.out.println(c);
		
		Car car = new Honda();
		car.stop(20);
		car.steer();
		car.start();
		
		System.out.println(car.h);
	}
}
