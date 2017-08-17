package com.ex.day3;

public class ThreadIntro {
	
	public static void main(String[] args) {
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		//et.run(); print out in a orderly fashion
		//ir.run(); print out in a orderly fashion
		
		et.start();
		
		Thread something = new Thread(ir); //creates a Thread object something which uses ir
		something.start();
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in anon class");
				for (int i = 0; i < 10; i++) {
					System.out.println(i + " in anon thread");
				}
			}
			
		};
		
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		
		//lambda
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int i = 0; i < 10; i++) {
				System.out.println(i + " lambda");
			}
		};
		
		Thread l = new Thread(lambda);
		l.start();
		
		//lambda
		//Runnable lambda2 = () -> 
	}

}

//extends Thread
class ExtendsThread extends Thread{
	
	public void run() {
		System.out.println("In ExtendsThread");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ExtendsThread");
		}
	}
}

//implement runnable 
class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("In ImplementsRunnable");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ImplementsRunnable");
		}
	}
	
}
