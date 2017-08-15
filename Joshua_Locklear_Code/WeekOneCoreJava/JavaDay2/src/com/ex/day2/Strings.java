package com.ex.day2;

public class Strings {
	public static void main(String[] args) {
		/*
		 * Strings are immutable
		 * once they're created they can't be changed
		 * the object created as a string is stored
		 * in the string pool
		 * 
		 * Every immutable object in java is "Thread safe"
		 * meaning they can't be manipulated by 2 threads at the same time
		 * A piece of code is thread safe if it only manipulates
		 * shared data structures in a manner
		 */
		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		String d = b;
		String e = new String("hello");
		System.out.println(a==b);
		System.out.println(a==d);
		//Next line of code prints false because == compares the same entity
		System.out.println(a==e);
		// Next line returns true because compares objects this also ignores the case
		System.out.println(a.equalsIgnoreCase(e));
		
		a.concat(" world");
		System.out.println(a);
		
		String con = a.concat(" world");
		System.out.println(con);
		
		a += a.concat(" world");
		System.out.println(a);
		
		System.out.println(e.indexOf("l"));
		System.out.println(e.lastIndexOf("l"));
		
		String nums = "0000000000";
		System.out.println(nums.replaceAll("000", "1"));
		
		String Letters = "kjlasdjfosdnvaasldfkjl";
		String alph = Letters.substring(10,11);
		System.out.println(alph);
	}
}
