package com.ex.day2;

public class StringBuilderandBuffer {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
//		System.out.println(str.equals(buff.toString())); //true
//		System.out.println(str == buff.toString()); //false
//		System.out.println(str.equals(build.toString())); //true
//		System.out.println(str == build.toString()); //false
//		System.out.println(buff.toString().equals(build.toString())); //true
//		System.out.println(buff.toString() == build.toString()); //false
		
		str.concat(" world/");
		buff.append(" world/");
		build.append(" world/");
		System.out.println(str+ " " + buff + " " + build);
	}

}
