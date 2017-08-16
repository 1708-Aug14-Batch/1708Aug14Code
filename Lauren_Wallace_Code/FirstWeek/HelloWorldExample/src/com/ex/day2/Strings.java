package com.ex.day2;

public class Strings {
	
	public static void main(String[] args) {
		/*
		 * Strings are immutable**
		 * once they're created they cannot be changed
		 * The project created as a string is stored
		 * in the string pool
		 * 
		 * Every immutable object in java is "thread safe",
		 * a piece of code is thread safe if it only
		 * manipulates shared data structures in a manner
		 * that 
		 */
		
		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		String d = b;
		String e = new String("hello");
		
		System.out.println(a==b);
		System.out.println(a==d);
		System.out.println(a==e);
		
		System.out.println(a.equals(e));
		
		
		//this is not being saved which is why the println below shows hello
		a.concat(" world");
		System.out.println(a);
		
		String con = a.concat(" world");
		System.out.println(con);
		
		//prints the first occurence of l in hello
		System.out.println(e.indexOf("l"));
		
		//prints the last occurence of l in hello
		System.out.println(e.lastIndexOf("l"));
		
		String nums = "OOOOOOOOOO";
		//System.out.println(nums.replaceFirst("OOO", 1));
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String alph = alphabet.substring(10, 11);
		System.out.println(alph);
	}
}
