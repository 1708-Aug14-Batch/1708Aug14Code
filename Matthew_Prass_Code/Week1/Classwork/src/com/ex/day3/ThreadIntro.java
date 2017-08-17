package com.ex.day3;

public class ThreadIntro {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		et.start();
		
		Thread rt = new Thread(ir);
		rt.start();
		
		Runnable anonRun = new Runnable()
		{

			@Override
			public void run() {
				
				System.out.println("in runnable");
				for(int i = 0; i <10; i++)
				{
					System.out.println(i+" in runnable");
				}
			}
			
		};
		
		Thread anon  = new Thread(anonRun);
		anon.start();
		
		Runnable lambda = () -> {
			System.out.println("in lambda");
			for(int i = 0; i <10; i++)
			{
				System.out.println(i+" in lambda");
			}
		};
		
		Thread l = new Thread(lambda);
		l.start();
	}
	
	//extends Thread
}

class ExtendsThread extends Thread
{
	public void run()
	{
		System.out.println("in extends thread");
		for(int i = 0; i <10; i++)
		{
			System.out.println(i+" in extends thread");
		}
	}
}

//implement runnable
class ImplementsRunnable implements Runnable{

	
	
	@Override
	public void run() {
		System.out.println("in implements runnable");
		for(int i = 0; i <10; i++)
		{
			System.out.println(i+" in implements runnable");
		}
		
	}
	
}
