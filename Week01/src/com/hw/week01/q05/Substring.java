package com.hw.week01.q05;

public class Substring {
	
	public static String substring(String str, int idx) {
		if (idx >= str.length()) {
			throw new ArrayIndexOutOfBoundsException("Index may not be equal to or greater than the length of the string.");
		}
		String output = "";
		char[] characters = str.toCharArray();
		for(int i = 0; i <= idx; i++) {
			output += characters[i];
		}
		return output;
	}

}
