package com.HW1.Q5;

public class SubString {
	
	public String substring(String str, int idx) {
		String sub = "";
		char[] arr = str.toCharArray();
		for(int i = 0; i < str.length(); i++) {
			if(idx == i) {
				break;
			}
			sub += arr[i];
		}
		return sub;
	}
	
}
