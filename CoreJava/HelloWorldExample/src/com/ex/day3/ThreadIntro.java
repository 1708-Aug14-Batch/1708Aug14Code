package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		Runnable lambda = ()->{
			System.out.println("running lambda");
		};
	}
	
	
	Runnable inner = new Runnable(){
		
		public void run(){
			System.out.println("running inner");
		}
		
	};
	
	
	
}


class ThreadClass extends Thread{
	public void run(){
		System.out.println("running from extending thread");
	}
}

class RunnableInterface implements Runnable{

	@Override
	public void run() {
		System.out.println("running from implementing interface");
	}
	
}

