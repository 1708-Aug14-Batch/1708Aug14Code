package com.ex.day2;

public class StringBuilderandBuffer {

	//Variable scopes:
	//local aka method
	//block aka 
	//
int x = 0;
static int stat = 10;
	public static void main(String[] args) {
		
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		//int x = 5; cannot do this, has to be static
		stat = 5; //is static
		
		//all separate objects
		//have to use toString() to get them to say true
		//equals() is value, == is whether or not it's pointing to the same object
		System.out.println(str.equals(buff));
		System.out.println(str.equals(build));
		System.out.println(buff.equals(build));
		
		//would not print out hello world
		//str.concat(" world");
		//would print out hello world
		buff.append(" world");
		build.append(" world");
		
		//would do the same thing as above
		doThings(str);
		buffThings(buff);
		buildThings(build);
		
		//edit
		
	}
	static String doThings(String s) {
		return s.concat(" world/");
	}
	
	static StringBuffer buffThings(StringBuffer sb)
	{
		return sb.append(" world/");
	}
	
	static StringBuilder buildThings(StringBuilder build)
	{
		return build.append(" world/");
	}
	
}
