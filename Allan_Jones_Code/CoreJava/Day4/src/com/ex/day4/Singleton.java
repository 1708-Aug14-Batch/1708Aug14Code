package com.ex.day4;

public class Singleton {
	//Thread safe
	public final static Singleton INSTANCE = new Singleton();

	private Singleton() {
		// Exists only to defeat instantiation.
	}

	public void doThat() {
		System.out.println("doing That");
	}

	public void doThis() {
		System.out.println("doing This");
	}
}