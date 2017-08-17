package com.HW1.Q3;

public class ReverseString {

	public String reverse(String str) {
		if(str.length() == 0 || str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverse(str.substring(1, str.length()-1)) + str.charAt(0);
	}
	
}
