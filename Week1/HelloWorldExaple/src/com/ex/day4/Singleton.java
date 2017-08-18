package com.ex.day4;

public class Singleton {
	
	private static Singleton obj = new Singleton();

	public Singleton() {
	
	}
	
	public static Singleton getObj(){
		return obj;
		
	}
	
	

}
