package com.ex.designpatterns;

public class Singleton {
	
	int count = 0;
	private static Singleton singleton = 
			new Singleton();
	/*
	 * private constructor prevents any 
	 * other class from instantiating this object
	 */
	
	private Singleton(){}
	

	// static "instance" method
	public static Singleton getInstance(){
		return singleton;
	}
	
	public void hello(){
		System.out.println("hey singleton!");
	}
}