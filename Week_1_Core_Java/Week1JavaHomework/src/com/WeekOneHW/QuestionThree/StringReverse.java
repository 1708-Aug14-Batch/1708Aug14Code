package com.WeekOneHW.QuestionThree;

import java.util.*; //Imports in the scanner

public class StringReverse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Creates the scanner object used for getting the string input
		String value = new String(); //Creates a new string object to reverse
		System.out.println("Enter a string: "); //Gets the string from input
		value = input.nextLine();
		
		for(int i = value.length() - 1; i >= 0; i--) { //For loop that initializes i at the end of string and increments backwards
			System.out.print(value.charAt(i)); //Prints out the character at i, thus reversing it.
		}

	}

}
