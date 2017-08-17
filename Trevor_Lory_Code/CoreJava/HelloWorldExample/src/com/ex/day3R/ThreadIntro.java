package com.ex.day3R;

public class ThreadIntro {

	public static void main(String[] args) {
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		et.start();
		
		Thread rn = new Thread(ir);
		rn.start();
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("In anon class");
				for(int i = 0; i < 10; i++) {
					System.out.println(i + " In anon Thread");
				}
			}
			
		};
		
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		
		//lambda
		
		Runnable lambda = () -> {
			System.out.println("In lambda");
			for(int i = 0; i < 10; i++) {
				System.out.println(i + " In lamba Thread");
			}
		};
		
		Thread lambdaThread = new Thread(lambda);
		lambdaThread.start();
	}
	
}

//extends Thread
class ExtendsThread extends Thread {
	
	public void run() {
		System.out.println("In Extends Thread");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in Extends Thread");
		}
	}
	
}

//implements Runnable
class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in Implements Runnable");
		}
	}
	
}