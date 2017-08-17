package com.revature.threads;

public class Main {
	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Lambda");
		for (int i=0; i<100000; i++)
			new Thread(r).start();
		System.out.println("Main");
	}
}
