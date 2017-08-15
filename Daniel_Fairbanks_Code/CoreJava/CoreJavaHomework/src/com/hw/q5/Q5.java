package com.hw.q5;


public class Q5 {

	public static String get_substring(String str, int idx) 
	{
		char[] ary = str.toCharArray();
		String retVal = "";
		for (int i = 0; i < idx; i++)
			retVal += ary[i];
		return retVal;
	}
	public static void main(String[] args) {
		String str = "Hello World!";
		int idx = 7;
		System.out.println(get_substring(str, idx));
	}

}
