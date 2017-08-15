package com.ex.HelloWorld;

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
		 * Primitive data type:
		 * int - Integer
		 * byte - Byte
		 * char - Character
		 * boolean - Boolean
		 * short
		 * long
		 * float
		 * double
		 */
		int a = 0;
		Integer aa = a;
		char c ='c';
		char d = 50;
		char e = '\u0000';
		
		int f =100000;
		
		c = (char) a;
		c = (char) f;
		
	//	System.out.println("int a:" +a);
		//System.out.println("char d:" + d);
		//System.out.println("char c:" + c);
		
		
		//System.out.println("Hello World");
		Car car = new Honda();
		car.stop(10);
	}

}
