package com.ex.day2;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		int[] arr = new int[4];
		try {
		arr[0] = 1;
		arr[4] = 5;
		System.out.println(arr[4]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("inside catch block");
		}
		System.out.println("hey i passed the exception");
		try {
			duckException();
		} catch (MyException me) {
			System.out.println(me.getMessage());
		}
	}
	
	/*
	 * Propogating your exception
	 */
	static void duckException() throws MyException{
		System.out.println("we are ducking exceptions");
		throw new MyException();
	}
	
}
