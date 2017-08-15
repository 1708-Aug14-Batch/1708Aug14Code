package com.ex.day2;

public class AcceptingExceptions {
	
	public static void main(String[] args) {
		int[] arr = new int[4];
		try {
			arr[0] = 1;
			arr[4] = 5;
			//This will create ArrayIndexOutOfBounds exception
			System.out.println(arr[4]);
			String str = new String();
			System.out.println(str);
		}
		catch(NullPointerException e) {
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("level 2");
		}
		catch(Exception e) {
		//	e.printStackTrace();
		}
		
		finally {
			System.out.println("inside finally");
		}
		
		System.out.println("I passed!");
		
		try {
		duckException();
		} catch (Exception e) {
			System.out.println("We caught a duck");			e.printStackTrace();
		}
		
	}
	
	static void duckException() throws Exception {
		System.out.println("We are ducking exceptions");
		throw new Exception();
	}

}
