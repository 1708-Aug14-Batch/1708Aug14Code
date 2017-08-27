package com.ex.day3;

public class ThreadIntro {
	
	public static void main(String[] args) {
		
		
		String str = "abc";
		int mid = (int) Math.floor(str.length()/2);
		
			
			
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		et.start();
		Thread something = new Thread(ir);
		something.start();
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("in anon class");
<<<<<<< HEAD:CoreJava/HelloWorldExample/src/com/ex/day3/ThreadIntro.java
				for(int i = 0; i<10;i++){
					System.out.println(i + " in anonclass");
					
					
=======
				for (int i = 0; i < 10; i++) {
					System.out.println("in anon loop");
>>>>>>> 180f12c7b0d57a9c83e21e95a382009138f07c36:Week01/src/com/ex/day3/ThreadIntro.java
				}
			}
		};
		
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		
		// lambda
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for (int i = 0; i < 10; i++) {
				System.out.println("in lambda loop");
			}
		};
		Thread l = new Thread(lambda);
		l.start();
		
	}

}

// extends thread
class ExtendsThread extends Thread {
	public void run() {
		System.out.println("In ExtendsThread");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in ExtendsThread");
		}
	}
}

// implements runnable
class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ImplmentsRunnable");
		}
	}
	
}