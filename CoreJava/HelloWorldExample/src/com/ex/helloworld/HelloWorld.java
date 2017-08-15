package com.ex.helloworld;

import com.ex.interfaces.Driveable;
import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

/*
 */

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
		 * Primitives 
		 * 
		 * A primitive wrapper class in Java is one of the 8 classes
		 * provided in the java.lang package to provide object methods
		 * for the 8 primitive data types. All 8 of the wrapper classes
		 * in java are immutable
		 * 
		 * 
		 * primitive , 	wrapper classes
		 * int - 		Integer 
		 * byte - 		Byte
		 * char	- 		Character
		 * boolean- 	Boolean
		 * short- 		Short
		 * long	- 		Long
		 * float- 		Float
		 * double- 		Double
		 * 
		 * autoboxing - the automatic conversion that the java compiler
		 * makes between the primitive types and their corresponding object
		 * wrapper classes. Helps save memory by reusing already created
		 * wrapper objects. 
		 * 
		 * Boxing != casting - used to convert one data type to another	 
		 */
		
		int a = 0;
		Integer auto = a; // autoboxing
		Integer explicit = new Integer(a); 
		
		char c = 'c';
		char d = 50;
		char e = '\u0000';
		
		int f = 19;
		
		
		//implicit casting:
		int x = c;
		
		
		/*
		 * explicit casting
		 */
		c = (char) a;
		c = (char) f;
		
		a = d;
		
//		System.out.println("int a: " + a);
//		System.out.println("char d: " + d);
//		System.out.println("char e: " + e);
//		System.out.println("char c: " + c);
		
	//	Driveable drive = new Driveable(); // cant instantiate interface
		Car car = new Honda(); 
		
		System.out.println(car.h);
		car.stop(4);
//		System.out.println("car.h " + car.h);
//		Honda honda = (Honda) car;
//		System.out.println("car.getH " +  honda.getH());
		//shadowing
		
	}

}
