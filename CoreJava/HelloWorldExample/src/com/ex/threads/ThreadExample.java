package com.ex.threads;

public class ThreadExample {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementRunnable ir = new ImplementRunnable();
		
		et.start();
		//ir.start();
		
		Thread someThread = new Thread(ir);
	
	
		Runnable anonRun = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("in anon class");
				for(int i = 0; i <10; i++) {
					System.out.println(i + " in anon class");
				}
			}
		};
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		
		//lambda
		
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int x = 0; x<10; x++) {
				System.out.println(x + " in lambda");
			}
		};
		
		Thread l = new Thread(lambda);
		l.start();
	}
}

// extends Thread

class ExtendsThread extends Thread{
	
	public void run() {
		System.out.println("In ExtendsThread");
		for(int i = 0; i <10; i++) {
			System.out.println(i + " in ExtendsThread");
		}
	}
}

// Implements Runnable

class ImplementRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("In ImplementsRunnable");
		for(int x = 0; x<10; x++) {
			System.out.println(x + " in ImplementsRunnable");
		}
	}
	
}