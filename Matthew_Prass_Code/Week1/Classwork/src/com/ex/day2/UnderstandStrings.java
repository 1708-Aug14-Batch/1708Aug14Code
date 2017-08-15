package com.ex.day2;

public class UnderstandStrings {
	
	public static void main(String args[]) {
		
		//edit
		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		String d = b;
		//does not equal the other "hello"s
		String e = new String("hello");
		
		//does not print out hello world,prints out hello because strings are immutable
		//meaning, they cant be changed
		//every immutable object is "thread safe"
		//A piece of code is thread-safe if it only manipulates shared data structures in a manner that guarantees safe execution by multiple threads at the same time."
		a.concat(" world");
		System.out.println(a);
		
		//the way to do it
		//the object created as a string is stored in the string pool
		String con = a.concat(" world");
		System.out.println(con);
		
		//can also do this
		a+= " world";
		System.out.println(a);
		
		
		String nums = "0000000000";
		System.out.println(nums.replaceAll("000", "1"));
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String alph = alphabet.substring(10, 11);
		System.out.println(alph);
		
		
	}

}
