package com.ex.question6;

import java.util.Scanner;

public class EvenOrNot {

	public static void main(String[] args) {
		
		//user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		int num  = s.nextInt();
		
		int x = Integer.remainderUnsigned(num, 2);
		if(x == 0)
			System.out.println("Even!");
		else
			System.out.println("Odd!");
		
		s.close();
	}
	
	//junit test method
	public static String evenorNaw(int num)
	{
		//return a new string that says a number is even or odd
		String result = "";
		int x = Integer.remainderUnsigned(num, 2);
		if(x == 0)
			result = "Even!";
		else
			result = "Odd!";
		return result;
	}

}
