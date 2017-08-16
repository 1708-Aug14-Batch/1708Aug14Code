package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		et.start();
		Thread irr = new Thread(ir);
		irr.start();
	}
	
	
}



// extends Tread
class ExtendsThread extends Thread{
	
	public void run() {
		System.out.println("In ExtendsThread");
		for(int i=0;i<10;i++) {
			System.out.println(i+" in ExtendsThread");
			
		}
	}
	
}

class ImplementsRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for(int i=0;i<10;i++) {
			System.out.println(i+" in ImplementsRunnable");
		}
	}
}