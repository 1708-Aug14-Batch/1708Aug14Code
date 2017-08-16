package com.WeekOneHW.QuestionFive;

import java.util.*; //Importing in the scanner

public class SubstringMethods {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Creating the scanner for input
		
		int idx = 0; //Creating the variable that will be the endpoint of our substring method
		
		System.out.println("Enter a string: "); //Getting the string
		StringBuilder str = new StringBuilder(input.nextLine()); //Created a StringBuilder that can be mutated with the substring method
		System.out.println("Enter the length of the substring you wish to return: "); //Got the length of the substring
		idx = input.nextInt();
		StringBuilder newSubString = subStringMethod(str,idx); //Created another StringBuilder set to the return of the subStringMethod
		System.out.println(newSubString); //Output the new string
		
	}
	
	static StringBuilder subStringMethod(StringBuilder str, int idx) {
		StringBuilder temp = new StringBuilder(); //Created a temp String to run through the following loop

		for(int i = 0; i <= idx - 1; i++) { //For loop that increments upwards stopping at the point given by the user
			temp.append(str.charAt(i)); //Appends the temp String, adding on to it with the char at i for the string given.
		}
		
		return temp; //Returns the temp value for output
	}
}
