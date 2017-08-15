package com.ex.strings;

public class UnderstandStrings {

	public static void main(String[] args) {
		String a = new String();
		a = "Hello";
		String b = new String();
		String c = "Hello";
		String e = "Hello";
		String d = b;
		String f = new String("Hello");
		
		
		System.out.println(a==c);
		System.out.println(a==e);
		System.out.println(a==f);
		
		a.concat(" World");
		System.out.println(a);
		a = a.concat(" World");
		System.out.println(a);
		
		
		
		
		

	}

}

