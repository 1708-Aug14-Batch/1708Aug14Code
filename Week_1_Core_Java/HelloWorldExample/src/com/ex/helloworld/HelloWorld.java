package com.ex.helloworld;

import com.ex.interfaces.Driveable;
import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

public class HelloWorld {
	/*
	 * Access modifiers:
	 * 	public - everything has access
	 * 	private - nothing has access
	 * 	protected - only access if its inherited
	 * 	package/default - only things inside the package can access it.
	 * 
	 * Can have multiple classes in a file, but only one can be public.
	 */
	
	public static void main(String[] args) {
		//Entirety of public static void main(String[] args) is the method signature
		//When something is static it doesn't need to be instantiated. It belongs to the class
		/*
		 * Primitive data types, Wrapper classes (called primitive because it only holds variables, can't do anything with):
		 * 	int - Integer
		 * 	byte - 
		 * 	char
		 * 	boolean (true, false) Wrapper class (true,false,void)
		 * 	short
		 * 	long
		 * 	float
		 * 	double - 
		 */
		int a = 0;
		Integer aa = a; //Called autoboxing (means it can go from primitive to wrapper without casting)
		
		char c = 'c'; //3 different ways to store chars. use single quotes
		char d = 50;
		char e = '\u0000';
		
		int f = 100000;
		
		c = (char)a; //Casting is changing its type.
		c = (char) f;
		
		a = d;
		
		//Strings are a series of characters. is an object.
//		System.out.println("int a: " + a);
//		System.out.println("char d: " + d);
//		System.out.println("char e : " + e);
//		System.out.println("char c: " + c);
		
		//Driveable drive = new Driveable(); //Can't instantiate interfaces
		Car car = new Honda();
		System.out.println("car h " + car.h);
		Honda honda = (Honda) car;
		System.out.println("honda h " + honda.h);
		System.out.println(car.getClass());
		
		//shadowing
	}
	
}
