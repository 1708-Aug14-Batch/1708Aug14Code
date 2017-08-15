package com.ex.helloworld;

import com.ex.interfaces.Drivable;
import com.ex.pojos.Honda;

public class HelloWorld {

	/*
	 * Access Modifiers:
	 * 		public
	 * 		private
	 * 		protected
	 * 		package/default
	 */
	// You can only have one public class in a source file.
	
	
	// When something is static it belongs to a class and so
	// the class does not have to be instantiated to use it
	public static void main(String[] args) {
		/*
		 * primitive data types, wrapper classes
		 * int - Integer
		 * byte - small unsigned ints
		 * char
		 * boolean - wrapper class also includes null
		 * short
		 * long
		 * float
		 * double
		 */
		
		
		int a = 0;
		Integer aa = a;	// this is called autoboxing, going between
		// primitive object and its wrapper class
		
		char c = 'c';
		char d = 50;
		char e = '\u0024';
		
		int f = 101435;
		c = (char) a;
		c = (char) f;
		
		a = d;
		
//		System.out.println("int a: "+a);
//		System.out.println("char d: "+d);
//		System.out.println("char e: "+e);
//		System.out.println("char c: "+c);
		
		
		Drivable car = new Honda();
		car.stop(50);
		car.steer();
		car.start();
		
		
	}
	
	
	
}
