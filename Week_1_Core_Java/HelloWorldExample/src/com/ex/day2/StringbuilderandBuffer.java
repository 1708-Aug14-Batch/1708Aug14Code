package com.ex.day2;

public class StringbuilderandBuffer {
	/*
	 * Variable scopes:
	 * local variables
	 * instance scope
	 * Method scope
	 */
	static int x = 0; //Instance scope
	int y = 10; //Can't use in static methods because its not static
	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		System.out.println(str==buff.toString());
		System.out.println(str==build.toString());
		System.out.println(buff.toString()==(build.toString()));
		x = 5;
		doThings(str);
		buffThings(buff);
		buildThings(build);

		System.out.println(str + buff + build);
		

		
	}
	static String doThings(String s) { //Method
		return s.concat(" world");
	}
	static StringBuffer buffThings(StringBuffer sb) {
		return sb.append(" world");
	}
	static StringBuilder buildThings(StringBuilder build) {
		return build.append(" world");
	}
}
