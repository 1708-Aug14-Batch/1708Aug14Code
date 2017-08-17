package Day3;

import Day3.ExtendsThread.ImplementsRunnable;

/**
 * 
 * @author joshw
 *@version 8/16/17
 */
public class ThreadIntro {
public static void main(String[] args) {
	ExtendsThread et = new ExtendsThread();
	ImplementsRunnable ir = new ImplementsRunnable();
	et.start();
	
	Thread something = new Thread(ir);
	something.start();
	
	Runnable anonRun = new Runnable(){
		
		@Override
		public void run() {
			
			for(int i = 0; i < 10; i++){
				System.out.println(i + " in ExtendsThread");
			}
		}
	};
}


// extends Thread
class ExtendsThread extends Thread{
	public void run(){
		System.out.println("in extends thread");
		for(int i = 0; i < 10; i++){
			System.out.println(i + " in ExtendsThread");
		}
	};
}

Thread anonThread = new Thread(anonRun);
anonThread.start();
//Implements runnable

class ImplementsRunnable implements Runnable{

	@Override
			public void run(){
			System.out.println("in extends thread");
			for(int i = 0; i < 10; i++){
				System.out.println(i + " in ExtendsThread");
		
	}
	
}
}