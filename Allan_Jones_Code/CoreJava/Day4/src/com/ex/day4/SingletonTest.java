package com.ex.day4;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton singleton = Singleton.INSTANCE;
		singleton.doThis();
		singleton.doThat();
	}
}
