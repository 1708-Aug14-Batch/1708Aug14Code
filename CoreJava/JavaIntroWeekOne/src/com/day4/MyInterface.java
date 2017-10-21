package com.day4;

public interface MyInterface {
	
	void method();
	default void myMethod() {
		System.out.println("Interface");
		
	}

}
