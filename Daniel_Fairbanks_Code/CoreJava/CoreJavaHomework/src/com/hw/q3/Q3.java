package com.hw.q3;

public class Q3 {

	public static void main(String[] args) {
		String testString = "Hello World!";
		char[] ts = testString.toCharArray();
		for (int i = ts.length-1; i >= 0; i--)
		{
			System.out.print(ts[i]);
		}
	}

}
