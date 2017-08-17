package com.ex.day4;

public class SingletonExample {
	
	private static final SingletonExample single = new SingletonExample();
	
	private SingletonExample() {
		
	}
	
	public static SingletonExample getInstance() {
		return single;
	}
	
	public void message() {
		System.out.println("I am the only instantiation of this class");
	}

}
