package com.ex.day2;

public class UnderstandingExceptions 
{
	public static void main(String args[]) {
		
		int[] arr = new int[4];
		
		try {	
		arr[0] = 1;
		arr[4] = 5;
		System.out.println(arr[4]);
		}
		//if we didnt catch this, the program would print the finally block, then crash
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("inside the catch block");
			System.out.println(e.getMessage());
		}
		
		finally {
			System.out.println("inside finally block");
		}
		
		System.out.println("boom! passed the exception");
		
		
		
		
		
		try {
			duckException();
		}catch(MyException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	static void duckException() throws MyException
	{
		System.out.println("quack!");
		throw new MyException();
	}
}
