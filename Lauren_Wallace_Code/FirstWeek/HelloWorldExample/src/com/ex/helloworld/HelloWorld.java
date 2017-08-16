package com.ex.helloworld;

import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

public class HelloWorld {
	/*
	 * Access modifiers:
	 * 		public
	 * 		private
	 * 		protected
	 * 		package/default
	 */

	public static void main(String[] args) {
		/*
		 * primitive data types, wrapper classes:
		 * int - Integer
		 * byte -
		 * char
		 * boolean
		 * short
		 * long
		 * float
		 * double
		 */
		
		int a = 0;
		Integer aa = a;
		
		char c = 'c';
		char d = 50;
		char e = '\u0000';
		
		int f = 100000;
		
		c = (char) a;
		c = (char) f;
		
		a = d;
		
//		System.out.println("int a: " + a);
//		System.out.println("char d: " + d);
//		System.out.println("char e: " + e);
//		System.out.println("char c: " + c);
		
		//Driveable drive - new Driveable(); // 
		Car car = new Honda();
		
		car.stop(50);
		car.steer();
		car.start();
		
		System.out.println(car.getClass());
	}

}
