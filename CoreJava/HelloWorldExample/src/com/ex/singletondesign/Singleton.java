package com.ex.singletondesign;

public class Singleton {
	// create object of itself
	private static Singleton instance = new Singleton();
	
	// private constructor so class cannot be instantiated
	private Singleton() {};
	
	public static Singleton getInstance() {
		return instance;
	}

	public void message() {
		System.out.println("singleton");
	}
}
