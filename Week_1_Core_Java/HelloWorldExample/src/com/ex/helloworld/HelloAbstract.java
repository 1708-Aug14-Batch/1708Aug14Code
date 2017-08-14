package com.ex.helloworld;

public abstract class HelloAbstract {
	//Can't have a main method in an abstract class because you cannot instantiate it.
	public abstract int math(int a, int b);
	
	public void doThings() {
		//Can define concrete methods in an abstract class
		
		System.out.println("Hello");
	}
	
}
