package com.ex.string;

public class Strings {

	public static void main(String[] args) {
		
		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		String d = b;
		String e = new String("Hello");
		
		System.out.println(a==b);
		System.out.println(a==d);
		System.out.println(a==e);
		// true true false
		
		System.out.println(a.equals(e));
		//.equalsIgnoreCase
		// true, compares content
	}
	
}
