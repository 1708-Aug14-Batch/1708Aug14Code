package com.ex.day2;

public class UnderstandingStrings {

	public static void main(String[] args) {
		/*
		 * Strings are immutable
		 * once they are created they cannot be changed
		 * The object created as a string is stored
		 * in the string pool
		 * 
		 * Every immutable object in java is "thread safe"
		 * meaning they cant be used by 2 threads at the same time
		 * 
		 * A piece of code is thread-safe if it only manipulates
		 * shared data structures in a 
		 * manner that guarantees safe execution by multiple threads at once
		 */
	String a = new String();
	a = "hello";
	String b = "hello";
	String c = "hello";
	String d = b;
	String e = new String("hello");
	System.out.println(a==b);
	System.out.println(a==d);
	System.out.println(a == e); //The reason this doesn't equal each other is that e is creating a new String object pointing somewhere else

	System.out.println(a.equals(e)); //This works by comparing the two and seeing if the content is true
	
	a += " world"; //Can use this to concat as well sometimes
	
	//String con = a.concat(" world"); //Strings are immutable, in order for concat to work you must save it to a new String variable
	System.out.println(a);
	
	System.out.println(e.lastIndexOf("l"));
	
	String nums = "0000000000";
	System.out.println(nums.replaceFirst("000", "1"));
	
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String alph = alphabet.substring(10, 11); //Beginning index is inclusive, ending index is exclusive
	System.out.println(alph);
	
	}
}
