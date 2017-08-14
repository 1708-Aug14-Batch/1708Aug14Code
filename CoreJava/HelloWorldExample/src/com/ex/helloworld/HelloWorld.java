package com.ex.helloworld;

import com.ex.interfaces.Driveable;
import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

public class HelloWorld {

	public static void main(String[] args) {
		int a = 0;
		Integer aa = a;
		
		char c = 'c';
		char d = 50;
		char e = '\u0000';
		int f = 100000;
		
		c = (char) a;
		c = (char) f;
		
		a = d;

		// Polymorphism
		//Car car = new Honda();
		Driveable car = new Honda(); // instance variable | methods
		
		car.stop(50);
		car.start();
		car.steer();
//		
//		System.out.println("int a " + a);
//		System.out.println("char d " + d);
//		System.out.println("char e " + e);
//		System.out.println("char c " + c);
	}
	
}
