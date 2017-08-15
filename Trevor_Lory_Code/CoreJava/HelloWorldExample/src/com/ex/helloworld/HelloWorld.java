package com.ex.helloworld;

import com.ex.pojos.Tesla;
import com.ex.vehicles.Car;

public class HelloWorld {
	//This is a comment
	/*
	 * This is
	 * also a comment
	 */
	
	public static void main(String[] args) {
//		int a = 0;
//		Integer aa = a;
//		
//		char c = 'a';
//		char d = 50;
//		char e = '\u0000';
//		
//		int f = 1000000;
//		c = (char)a;
//		c = (char)f;
//		
//		a = d;
//		
//		System.out.println("int a: " + a);
//		System.out.println("char d: " + d);
//		System.out.println("char c: " + c);
		
		Car car = new Tesla();
		Tesla TCar = new Tesla();
		
		car.deccelerate(50);
		car.accelerate(50);
		TCar.accelerate(50);
		//shadowing
		System.out.println(car.h);
		Tesla tes = (Tesla) car;
		System.out.println(tes.geth());
		
	}
}
