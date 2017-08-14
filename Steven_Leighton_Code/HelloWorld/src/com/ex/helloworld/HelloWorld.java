package com.ex.helloworld;

import javax.print.attribute.standard.PrinterLocation;

import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

public class HelloWorld {
	/*
	 * Access modifiers:
	 * 		public
	 * 		private
	 * 		protected (things that inherit from)
	 * 		package/default (within same package or extended from)
	 * Only one public class per source file
	 */
	
	public static void main(String[] args) {
		//boxing
		int a = 0;
		Integer aa = a;
		
		//char
		char c = 'c';
		char d = 50;
		char e = '\u0000';
		
		int f = 100000;
		
		//casting
		c = (char) a;
		c = (char) f;
		
		a = d;
		
//		System.out.println("int a: " + a);
//		System.out.println("char d: " + d);
//		System.out.println("char e: " + e);
//		System.out.println("char c: " + f);
		
		Car car = new Honda(); //polymorphism, can be Car or Driveable
							   //Honda -> Car -> Driveable
		car.stop(50);//in Car and Honda
		car.steer(); //in Driveable
		car.start(); //in Driveable
		
	}
}
