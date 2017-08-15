package com.ex.Exc;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		
		int[] arr = new int[4];
		try {
			arr[0] = 1;
			arr[4] = 5;
			System.out.println(arr[4]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("inside finally block"); //If no catch will crash after printing this message
		}
		
		System.out.println("Hey I passed the exception!");
		
		try {
			duckException();
		}
		catch(MyException e) {
			System.out.println("We caught our ducking exception");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//duckException();
		
	}
	
	static void duckException() throws MyException {
		System.out.println("We are ducking excpetions");
		throw new MyException();
	}
	
}
