package com.ex.exceptions;

public class Exceptions {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		int[] arr = new int[4];
		
		try {
		arr[0] = 1;
		arr[4] = 5;
		System.out.println(arr[4]);
		
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("catch block");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("finally block");
		}
		System.out.println("exception passed");
		
		try {
			duckException();
		}
		catch(MyException me) {
		//	System.out.println("caught duck");
			System.out.println(me.getMessage());
		}
	}
	
	static void duckException() throws MyException {
		System.out.println("duck exception");
		
		throw new MyException();
	}

}
