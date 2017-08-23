package com.ex.day3;

public class ThreadIntro {
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		et.start();
		Thread something = new Thread(ir);
		something.start();
		
		Runnable anonRun = new Runnable() {

			@Override
			public void run() {
				System.out.println("in anon class");
				for (int i = 0; i < 10; i++) {
					System.out.println("in anon loop");
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