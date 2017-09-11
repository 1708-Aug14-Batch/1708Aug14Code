package com.ex.day4;

public class SingletonEx {
	// not guaranteed thread-safe
	private static SingletonEx instance = null;

	protected SingletonEx() {
		// Exists only to defeat instantiation.
	}

	public static SingletonEx getInstance() {
		if (instance == null) {
			synchronized (SingletonEx.class) {
				if (instance == null) {
					instance = new SingletonEx();
				}
			}
		}
		return instance;
	}
}
