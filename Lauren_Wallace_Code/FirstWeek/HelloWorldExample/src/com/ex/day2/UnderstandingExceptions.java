package com.ex.day2;

public class UnderstandingExceptions {
	
	public static void main(String[] args) {
		
		int[] arr = new int[4]; 
		
		try {
			arr[0] = 1;
			arr[4] = 5;
		
			System.out.println(arr[4]);
			
		}
		//catch (Exception e) {
			//e.printStackTrace();
		//}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		finally {
			System.out.println("inside finally block");
		}
		System.out.println("hey I passed the exception");
		
		//try {
				//duckException();
		//}catch (//MyException me) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
	}
	
	static void duckException() throws Exception {
		System.out.println("we are ducking exceptions");
		throw new Exception();
	}

}
