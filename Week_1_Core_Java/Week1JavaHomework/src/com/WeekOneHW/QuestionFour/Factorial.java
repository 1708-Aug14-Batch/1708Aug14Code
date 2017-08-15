package com.WeekOneHW.QuestionFour;

import java.util.*; //Importing Java.util so that the Scanner can be used for user input

public class Factorial {

	public static void main(String[] args) { //Main function
		
		int x; //Setting up the variable used in the factorial
		Scanner input = new Scanner(System.in); //Creating the scanner object
		System.out.print("Enter a number to find its factoral: "); //Getting the users input
		x = input.nextInt(); //Using the scanner object to get the number the user wants to calculate.
		System.out.println(getFactorial(x)); //Runs the getFactoral function and ouputs the result.
	}
	
	public static int getFactorial(int x) { //The getFactoral function. It's static since its part of the same class.
		/*
		 * The following is using recursion to calculate the factorial
		 */
		if(x == 0) //When x reaches 0 return 1
			return 1;
		else //Else use recursion to rerun the function to get the result.
			return x = x * getFactorial(x-1);
	}

}
