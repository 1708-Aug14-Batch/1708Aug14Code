package com.ex.hellowrold;

import com.ex.interfaces.Driveable;
import com.ex.pojo.Honda;
import com.ex.vechiles.Car;

public class HelloWorldExample {
	
	public static void main(String[] Args){
		int a =0;
		Integer aa=a;
		
		char c='c';
		char d=50;
		char e='\u0000';
		
		int f = 100000;
		
		c=(char)a;
		c=(char)f;
		a=d;
		
//		System.out.println(a);
//		System.out.println(d);
//		System.out.println(e);
//		System.out.println(c);
		
		//Driveable drive = new Driveable();//cant instantiate interface
		Car car = new Honda(); //poly
		Honda honda =(Honda) car;
		//Honda car = new Honda();
		//Driveable car = new Honda(); //poly
		car.stop(50);
		car.steer();
		car.start();
		
		System.out.println(car.getClass());
		System.out.println(car.h);
		System.out.println(honda.getH()); // getter setter only in honda not in car
	}

}
