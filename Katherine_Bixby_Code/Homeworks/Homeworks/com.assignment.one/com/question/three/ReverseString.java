package com.question.three;

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
		
		if(theString.length()==0||theString.length()==1){
			return theString;
		}
		return theString.charAt(theString.length()-1) + reverseString(theString.substring(1, theString.length()-1)) + theString.charAt(0);
			
	}
	
}
