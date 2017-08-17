package com.revature.threads;

public class Timer implements Runnable {
	
	int i;
	public Timer(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("Thread " + i);
			try {
				Thread.sleep((i + 1) * 200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
