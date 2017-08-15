package com.ex.day2;

public class UnderstandingExceptions {

	public static void main(String[] args) throws Exception {
		int[] arr = new int[4];
		try {
			
			arr[0] = 1;
			arr[6] = 5;
			System.out.println(arr[4]);
			System.out.println("past first exception");
			String str = null;
			System.out.println(str.indexOf('a'));
			System.out.println("reached the end of the try block");
		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		catch(ArrayIndexOutOfBoundsException e) { //Catches the exception, outputs the statement and allows the next output to continue
			System.out.println("Inside catch block");
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		//Null Pointer Exception is thrown when a resource is trying to access a variable that is null
		catch(NullPointerException e) { //Catches the exception, outputs the statement and allows the next output to continue
			System.out.println("Inside catch block");
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		finally { //Put any final statements in finally. Such as closing a stream or a file.
			System.out.println("inside finally block");
		}
		System.out.println("Hey I passed the exception");
		try {
		duckException();
		}
		catch(MyException me) {
			System.out.println(me.getMessage());
		}
		

	}
	static void duckException() throws Exception { //Ducking, also known as proprogating
		System.out.println("We are ducking exceptions");
		throw new MyException();
	}
}
