package com.question.sixteen;

/**
 * A program to display the number of characters for a string input.
 * The string is entered as a command line argument using (String [ ] args).
 * 
 * @author Katie
 */

public class StrLength {

	public static void main(String[] args) {
		String theString;
		theString = args[0];
		int len = theString.length();
		System.out.println("The length of the given string is: "+len+" characters!");
		
	}
	
}
