package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		
		
		Thread something = new Thread(ir); //Doesn't extend thread but can be used as the arguement in creating a Thread object.
		
		
	
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in anon class");
				for(int i = 0; i<10;i++)
					System.out.println(i+ " in anon.");
			}
			
		};
		Thread anonThread = new Thread(anonRun); 
		
		
		//lambda
		
		Runnable lambda = () ->{ //Lambda syntax is ->. () is because it has one method to implement
			System.out.println("In lambda runnable");
			for(int i = 0; i < 10; i++) {
				System.out.println(i + " in lambda");
			}
		};
		Thread l = new Thread(lambda);
		
		et.start(); //Extends Thread so has the start() method
		something.start();
		anonThread.start();
		l.start();
		
	}
	
}

//Extends thread

class ExtendsThread extends Thread{
	
	public void run() {
		System.out.println("In ExtendsThread");
		for(int i = 0; i <10; i++) {
			System.out.println(i + " in ExtendsThread");
		}
	}
}

//implements runnable
class ImplementsRunnable implements Runnable{ //Implementing runnable forces you to put in run()

	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for(int i=0; i<10; i++) {
			System.out.println(i + " in IMplementsRunnable");
		}
		
	}

	
}