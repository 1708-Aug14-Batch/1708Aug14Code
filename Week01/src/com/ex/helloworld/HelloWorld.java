/**
 * 
 */
package com.ex.helloworld;

import com.ex.interfaces.Driveable;
import com.ex.pojos.Honda;

/**
 * @author will
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 0;
		Integer aa = a; // auto-boxing
		
		char c = 'c';
		char d = 50; // unicode value
		char e = '\u0000';
		
		int f = 1000;
		
		c = (char) a;
		c = (char) f;
		
		a = d;
		
		/*System.out.println("int a: " + a);
		System.out.println("char d: " + d);
		System.out.println("char e: " + e);
		System.out.println("char c: " + c);*/
		
		Driveable car = new Honda();
		
		car.stop(50);
	}

}
