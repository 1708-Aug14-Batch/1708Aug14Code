package com.ex.day2;

public class UnderstandingExceptions {
	
	public static void main(String[] args) {
		
		int[] arr = new int[4];
		
		try{
		arr[0] = 1;
		arr[6] = 5;
		System.out.println(arr[4]);
		
		System.out.println("past first exception");
		String str = null;
		System.out.println(str.indexOf('a'));
		System.out.println("reached end of try block");
		}
//		catch(Exception e){
//			e.printStackTrace();
//		}

		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("inside catch block");
		//	System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		catch(NullPointerException e){
			System.out.println("inside catch block");
			//System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		finally{
			System.out.println("inside finally block");
		}
		
		System.out.println("hey i passed the exception");
		try{
			duckException();}
		catch(MyException me){
			System.out.println(me.getMessage());
		}
		
	}
	
	static void duckException() throws MyException{
		System.out.println("we are ducking exceptions");
		throw new MyException();
		
	}
	
	/*
	 * 
	 * 
	 * Best Practices with Exceptions:
	 * - Never Hide Exceptions. At the least log them. printStackTrace
	 * 	 method prints the entire stack trace when an exception occurs. 
	 * 	 If you handle an exception, it is always a good practice to log
	 *   the trace.
	 * - Do not use exception handling for flow control in a program. They 
	 * 	 have a significant performance impact.
	 * - Think about the user. What does the user want to see if there 
	 *   is an exception?
	 * - Think about the support developer. What does the support developer 
	 *   need to debug the exception?
	 * - Think about the calling method. Can the calling method do something
	 * 	 about the exception being thrown? If not, create un checked 
	 *   exceptions. For example, Spring Framework chooses to make most of 
	 *   the jdbc exceptions as unchecked exceptions because , in most cases,
	 *   there is nothing that a caller of the method can do about a jdbc exception.
	 */
	
	
	

}
