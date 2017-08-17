package com.ex.helloworld;

import com.ex.interfaces.Drivable;
import com.ex.pojos.Honda;
import com.ex.vehicles.Car;

public class HelloWorld {
	

	public static void main(String[] args) {
		int a = 0;
		//Integer aa = a;//auto boxing, didn't have to cast
		char c = 'f';
		char d = 50;
		char e = '\u0000'; 
		
		int f = 100000;
		
		c = (char) a;
		c = (char) f;
//		
//		System.out.println("int"+a);
//		System.out.println("d" + d);
//		System.out.println("e"+e+"c"+c);
		
		
		
		//this is polymorphism
		/*r
		 * eference variables of the reference 
		 * type & methods of the instance type,
		 * however, we cannot access methods from the instance type
		 * that are not in the reference type
		 * Apparent data type determines what methods & variables may be called,
		 * Actual data type determines what the methods do
		 */
		Drivable car = new Honda();
		/*
		 * You only what to do DRIVABLE stuff, but you want the Honda way of doing it
		 * i.e Hondas might play movies, but you don't care rn
		 */
		car.stop(20);
		car.steer();
		car.start();
		System.out.println("stop");
	}
	

}
