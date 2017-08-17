package com.ex.day4;

public class LazySingleton {

	//doesnt instantiate at class load
	private static LazySingleton instance;
	
	//hide constructor
	private LazySingleton(){};
	
	//instantiate at first global access call
	public static LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
}
