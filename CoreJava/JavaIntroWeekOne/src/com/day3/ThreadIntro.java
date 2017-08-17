package com.day3;

public class ThreadIntro {
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunable ir = new ImplementsRunable();
		
//		et.start();
		Thread something = new Thread(ir);
	//	something.start();
		
	
	
	Runnable anonRun = new Runnable() {

		@Override
		public void run() {
			System.out.println("In anon Run");
			for(int i=0;i<10;i++) {
				System.out.println(i+" in anon Run");
			}			
		}
		
	};
	
	Thread anonThread = new Thread(anonRun);
//	anonThread.start();
	
	Runnable lambda = () -> {
		System.out.println("In lambda");
		for(int i=0; i<10;i++) {
			System.out.println(i+" in lambda");
		}
	};
	
	Thread lamThread = new Thread(lambda);
	
	et.start();
	something.start();
	anonThread.start();
	lamThread.start();
	
	}
}

//extends Thread
class ExtendsThread extends Thread{
	public void run() {
		System.out.println("In Extends Thread");
		for(int i=0;i<10;i++) {
			System.out.println(i+" in ExtendsThread");
		}
	}
}


//implements runable
class ImplementsRunable implements Runnable{
//
//	ImplementsRunable(){
//		
//	}
	
	
	
	
	@Override
	public void run() {
		System.out.println("In Implement Runnable");
		for(int i=0;i<10;i++) {
			System.out.println(i+" in ImplementThread");
		}
	}
	
}