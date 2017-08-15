package com.WeekOneHW.QuestionSix;

import java.util.*; //Importing in Java.util to get the scanner

public class NoModulus {

	public static void main(String[] args) {
		int x; //This is the variable that we will use to determine if even or not.
		boolean result = true; //The boolean variable used to determine if even or odd
		Scanner input = new Scanner(System.in); //Creating the scanner object
		
		System.out.print("Enter a number: "); //Output and getting the users input
		x = input.nextInt();
		
		result = isEven(x); //Setting the boolean variable to the result of the isEven function
		if(result == true) //Outputs the result if true or false
			System.out.println("The number is even");
		else
			System.out.println("The number is odd");
	}

	public static boolean isEven(int x) { //The isEven function that returns a boolean
		String number = Integer.toString(x); //Created a String variable and used a wrapper class of the integer x to set it.
		char last = number.charAt(number.length()-1); //Created a char thats set to the last char of the number String.
		
		/*
		 * If the char last is equal to any of the chars set to even numbers, return true. Otherwise return false
		 */
		if(last == '2' || last == '4' || last == '6' || last == '8' || last == '0') {
			return true;
		}
		else {
			return false;
		}
	}
}
