package com.ex.day2;

public class StringBuilderandBuffer {
	/*
	 * variable scopes:
	 * local aka method
	 * block aka loop
	 * member aka class
	 * static 
	 */
int x = 0;
static int stat = 10;
	
	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		stat = 5;
//		System.out.println(str == buff.toString());
//		System.out.println(str == build.toString());
//		System.out.println(buff.toString() == build.toString());
	
	stringThings(str);
	buffThings(buff);
	buildThings(build);
	
	int x = 3;
	x *= 4;
	x+=7;
	x/=10;
	
	System.out.println(str + " " + buff + " " + build);
	
	
	}
	
	static String stringThings(String s){ //method scope
		return s.concat(" world/");
	}
	
	static StringBuffer buffThings(StringBuffer sb){
		return sb.append(" world/");
	}
	
	static StringBuilder buildThings(StringBuilder build){
		return build.append(" world/");
	}
	
}
