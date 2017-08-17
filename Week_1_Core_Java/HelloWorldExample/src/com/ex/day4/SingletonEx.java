package com.ex.day4;

public class SingletonEx {
	
	private static SingletonEx instance = null;
	private SingletonEx() {
		
	}
	public static SingletonEx getInstance() {
		if(instance == null) {
			instance = new SingletonEx();
		}
		return instance;
	}
	
	public void printInfo() {
		
		System.out.println("This is a Singleton test");
	}
	
}
