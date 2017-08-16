package com.question.five;

public class GetSubstring {

	public static String getSubstring(String str, int idx) {
		
		char[] charArr = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			charArr[i] = str.charAt(i);
		}
		String theSubstring = "";
		for (int i=0;i<idx;i++) {
			theSubstring+=Character.toString(charArr[i]);
		}
		
		return theSubstring;
	}
	
}
