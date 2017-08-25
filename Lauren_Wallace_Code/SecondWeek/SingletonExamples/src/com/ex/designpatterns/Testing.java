package com.ex.designpatterns;

public class Testing {

	public static void main(String[] args) {
		
		/*
		 * Must use getInstance() method to instantiate singleton class
		 */
		Singleton singletonEx = Singleton.getInstance();
		singleton.hello();
		
		Singleton newOne = Singleton.getInstance();
		singleton.count = 10;

		System.out.println(newOne.count);
		
		/*
		 * Factory design pattern 
		 * here, we create an object 
		 * 
		 * 
		 * 
		 */
	}

}
