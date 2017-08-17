package com.ex.day4;

public class EagerSingleton {

	//initializes at the class load
	private static final EagerSingleton instance = new EagerSingleton();
	
	//private constructor to hide instantiation
	private EagerSingleton(){}
	
	//global access
	public static EagerSingleton getInstance(){
		return instance;
	}
}
