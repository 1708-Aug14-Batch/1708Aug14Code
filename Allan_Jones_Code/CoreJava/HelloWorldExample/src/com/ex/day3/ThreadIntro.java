package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		
		
		String str = "abc";
		int mid = (int) Math.floor(str.length()/2);
		
			
			
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		Thread something = new Thread(ir);
		
		
		Runnable anonRun = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in anon class");
				for(int i = 0; i<10;i++){
					System.out.println(i + " in anonclass");
					
					
				}
			}
			
		};
		
		
		Thread anonThread = new Thread(anonRun);
		
		
		//lambda
		
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int i = 0; i < 10; i++){
				System.out.println(i + " lambda");
			}
		
		};
			
		Thread l = new Thread(lambda);
		l.run();
		anonThread.run();
		et.run();
		something.run();
		//lambda.run();
	}


}


// extends Thread
class ExtendsThread extends Thread{
	
	public void run(){
		
		System.out.println("In ExtendsThread");
		for(int i = 0; i<10 ; i++){
			System.out.println(i + " in ExtendsThread");
		}
	}
}

//implement runnable
class ImplementsRunnable implements Runnable{
	
	
	
	@Override
	public void run() {
		System.out.println("In ImplementsRunnable");
		for(int i=0; i<10;i++){
			System.out.println(i + " in ImplementsRunnable");
		}
	}
	
}
