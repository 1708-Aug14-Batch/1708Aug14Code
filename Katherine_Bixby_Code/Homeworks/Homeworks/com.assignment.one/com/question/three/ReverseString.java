package com.question.three;

import java.util.Stack;


/**
 * This is my class for reversing a string of input theString.
 * It puts each character (as a string) into a stack, then after it pushes all
 * the characters, it pops them back out and stores that popped out string into
 * a new string via concatenation.
 * It then returns the reversed string.
 * @author Katie
 *
 */

public class ReverseString {

	/**
	 * The method you can call to reverse a string
	 * @param theString
	 * 		String to be reversed
	 * @return
	 * 		The reversed String
	 */
	public static String reverseString(String theString) {
		
		Stack<String> strStack = new Stack<String>(); // the String stack
		String charChar; // for containing each String char value to put on or take off the stack
		for(int i=0;i<theString.length();i++) { // go through the whole string
			charChar = theString.substring(i, i+1); // put the character there onto the String stack
			strStack.push(charChar);
		}
		String newString = ""; // establish a new String that will contain the reversed String
		for(int i=0;i<theString.length();i++) {	// go through the stack
			charChar = strStack.pop(); // take the top value off the stack (which was the last character of the String
			// continue to go down the stack in this way, appending each character (the latest in the stack) to the new reversed
			// String...thus reversing the String.
			newString+=charChar;
		}
		
		
		return newString;
	}
	
}
