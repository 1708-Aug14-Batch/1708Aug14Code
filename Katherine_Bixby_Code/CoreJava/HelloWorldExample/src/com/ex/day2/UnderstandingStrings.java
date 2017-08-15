package com.ex.day2;

public class UnderstandingStrings {

	public static void main(String[] args) {
		/*
		 * Strings are immutable
		 * once they're created they can't be changed
		 * The object created as a string is stored
		 * in the string pool
		 * 
		 * Every immutable object in java is "thread safe"
		 * A piece of code is thread-safe if it only
		 * manipulates shared data structures in a
		 * manner that guarantees safe execution
		 * by multiple threads at a time
		 */
		
		String a = new String();
		a = "Hello";
		String b = new String();
		String c = "Hello";
		String e = "Hello";
		String d = b;
		
		String f = new String("Hello");
		
//		System.out.println(a==c); // true
//		System.out.println(a==e); // true
//		System.out.println(a==f); // false, because it will check if it's the same index
//		
//		System.out.println(a.equals(e)); // true - also .equals() is case sensitive, but you can use .equalsIgnoreCase()
		
		a.concat(" world"); // not actually changing a right here so will only print out 'hello'
		System.out.println(a);
		String con = a.concat(" world");
		System.out.println(con); // now this prints out the new saved value
		System.out.println(e.indexOf("l")); // prints out the index of the first time something appears
		
		String nums = "0000000000";
		System.out.println(nums.replaceAll("000", "1"));
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String alph = alphabet.substring(10, 11);
		System.out.println(alph);
	}
}
