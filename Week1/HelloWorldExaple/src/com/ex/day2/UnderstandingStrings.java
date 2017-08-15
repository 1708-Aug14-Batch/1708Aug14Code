package com.ex.day2;

public class UnderstandingStrings {
	public static void main(String[] args) {	
		/*
		 * Strings are immutable
		 * once they are created can't be changed
		 * the object created as a string is stored in the string pool
		 * 
		 * Every immutable object in java "thread safe"
		 * Apiece of code is thread-safe
		 */

	String a = new String();
	a = "hello";
	String b = "hello";
	String c = "hello";
	String d = b;
	String e = new String("hello");
	
	a.concat("world");
	
	
	System.out.println(a==b);
	System.out.println(a==d);
	System.out.println(a==e);
	
	System.out.println(a.equals(e));
	
			
	}
	

}
