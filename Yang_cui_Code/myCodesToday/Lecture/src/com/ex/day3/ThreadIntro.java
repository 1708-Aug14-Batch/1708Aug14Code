package com.ex.day3;

public class ThreadIntro {
	static String filename="src/com/ex/files/student.txt";
	public static void main(String[] args){
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		//et.run();
		//ir.run();
		et.start();
		Thread something= new Thread(ir);
		something.start();
		
		Runnable anonRun =new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("In anon class");
				for(int i=0; i<10; i++){
					System.out.println(i+" In anon class");
				}
			}
			
		};
		
		Thread anonThread=new Thread(anonRun);
		anonThread.start();
		
		//lambda
		Runnable lambda = ()->{
			System.out.println("In runnable lambda");
			for(int i=0; i<10; i++){
				System.out.println(i+" In runnable lambda");
			}
		};
		
		Thread l = new Thread(lambda);
		l.start();
		lambda.run();
	}
}

//extends thread
class ExtendsThread extends Thread{
	public void run(){
		System.out.println("In ExtendsThread");
		for(int i=0; i<10; i++){
			System.out.println(i+" In Extends Thread");
		}
	}
}

//implement runnable
class ImplementsRunnable implements Runnable{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("In ImplementsRunnable");
		for(int i=0; i<10; i++){
			System.out.println(i+" in ImplementsRunnable");
		}
	}
	// extend thread cannot extend class
}