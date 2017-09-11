package com.ex.day2;

public class UnderstandingStrings {
	
	static int stat = 0;
	public static void main(String[] args) {
		/*
		 * Strings are immutable**
		 * once they're created they cant be changed
		 * The object created as a string is stored
		 * in the string pool
		 * 
		 * Every immutable object in java is "thread safe"
		 *  A piece of code is thread-safe if it only
		 *  manipulates shared data structures in a 
		 *  manner that guarantees safe execution by 
		 *  multiple threads at the same time
		 * 
		 */
		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		String d = b;
		String e = new String("hello");
		
		a.concat(" world");
		System.out.println(a);
		
		System.out.println(e.lastIndexOf("l"));
		
		String nums = "0000000000";
		System.out.println(nums.replaceAll("000", "1"));
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String alph = alphabet.substring(10, 10);
		System.out.println(alph.equals(""));
		
	}


}
