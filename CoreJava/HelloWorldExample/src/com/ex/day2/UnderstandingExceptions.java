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
	
	
	
	

}
