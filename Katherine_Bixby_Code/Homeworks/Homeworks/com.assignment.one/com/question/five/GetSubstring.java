package com.question.five;

/**
 * A method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive.
 * @author Katie
 *
 */
public class GetSubstring {

	/**
	 * Get the substring
	 * @param str
	 * 		The string to get substring from
	 * @param idx
	 * 		The end index of the substring to get
	 * @return
	 * 		The substring
	 */
	public static String getSubstring(String str, int idx) {
		
		char[] charArr = new char[str.length()];	// converts string to char array
		for(int i=0;i<str.length();i++) {
			charArr[i] = str.charAt(i);	// converting that string to char array
		}
		String theSubstring = "";	// instantiate the substring
		for (int i=0;i<idx;i++) {
			theSubstring+=Character.toString(charArr[i]);	// add the characters between the indexes given.
		}
		
		return theSubstring;
	}
	
}
