package com.revature.singleton;

public class Singleton {
	
	
	private static class SingletonHelper {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
