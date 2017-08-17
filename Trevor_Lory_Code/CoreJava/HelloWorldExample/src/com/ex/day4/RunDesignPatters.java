package com.ex.day4;

public class RunDesignPatters {

	public static void main(String[] args) {
		Singleton in = Singleton.getInstance();
		Singleton in2 = Singleton.getInstance();
		in.TestString = "Test";
		System.out.println(in2.TestString);
		System.out.println(in.factory(0).getName());
		System.out.println(in.factory(1).getName());
	}
	
}
