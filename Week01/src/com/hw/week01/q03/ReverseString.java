package com.hw.week01.q03;

public class ReverseString {
	
	public static String reverse(String string) {
		if (string.length() == 0 || string.length() == 1) {
			return string;
		}
		return string.charAt(string.length() - 1) 
				+ reverse(string.substring(1, string.length() - 1)) 
				+ string.charAt(0);
	}

}
