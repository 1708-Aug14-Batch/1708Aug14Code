package com.ex.helloworld;

import com.ex.interfaces.Drivable;
import com.ex.pojos.Honda;

public class HelloWorld {

	/*
	 * Access modifiers:
	 * 	public			-Everyone has access
	 * 	private			-Only this class has access
	 * 	protected		-Package and subclass access
	 * 	package/default	-Package access
	 */
	
	public static void main(String[] args) {
		/*
		 * primitive data types - associated wrapper class:
		 * 	char	- 
		 * 	int		- Integer
		 * 	short	- 
		 * 	long	- 
		 * 	byte	- 
		 * 	float	- 
		 * 	double	- 
		 * 	boolean	- 
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
		
		System.out.println("int a: " + a);
		System.out.println("Integer aa: " + aa);
		System.out.println("char d: " + d);
		System.out.println("char e: " + e);
		System.out.println("char c: " + c);
		
		// Dirvable drive = new Drivable();	// can't instantiate an interface
		Drivable car = new Honda();
		
		car.stop(50);
		car.steer();
		car.start();
		
		System.out.println(car.getClass());
		
		
	}
}
