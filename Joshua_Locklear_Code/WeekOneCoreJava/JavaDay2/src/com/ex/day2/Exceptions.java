package com.ex.day2;

public class Exceptions {
	public static void main(String[] args){
		int[] myArray = new int[4];
		try{
			
		
			myArray[0]=1;
			myArray[4]=5;
		
			System.out.println(myArray[4]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("inside catch block");
			e.getMessage();
		}finally{
			System.out.println("Inside Finally");
		}
		System.out.println("Hey I passed the exception");
	}
}
