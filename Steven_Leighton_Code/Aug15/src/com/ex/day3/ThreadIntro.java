package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
//		et.run();
//		ir.run();
//		
		Runnable anonRun = new Runnable(){

			@Override
			public void run() {
				System.out.println("in anonthread");

				for(int i = 0; i <10 ; i++){
					System.out.println(i + " in anonthread");
				}
			}
			
		};
		
		//lambda
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int i = 0; i <10 ; i++){
				System.out.println(i + " in lambda");
			}
		};
		
		et.start();
		Thread rt = new Thread(ir); //need a thread object
		rt.start();
		Thread anonThread = new Thread(anonRun);
		anonThread.start();
		Thread lambdaThread = new Thread(lambda);
		lambdaThread.start();
	}
}

//extends Thread
class ExtendsThread extends Thread{

	@Override
	public void run(){
		System.out.println("in extendsthread");

		for(int i = 0; i <10 ; i++){
			System.out.println(i + " in extendsthread");
		}
	}
}

//implement runnable, use to implement other interfaces
class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("in implRunnable");

		for(int i = 0; i <10 ; i++){
			System.out.println(i + " in implRunnable");
		}
	}

}