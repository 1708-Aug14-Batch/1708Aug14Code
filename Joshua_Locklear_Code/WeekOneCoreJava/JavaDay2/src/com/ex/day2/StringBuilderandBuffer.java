package com.ex.day2;

public class StringBuilderandBuffer {

	public static void main(String[] args) {
		/*
		 * variable scopes
		 * local aka method
		 * block aka loop
		 * member aka class
		 */
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("Hello");
		
		//System.out.println(str.equals(buff.toString()));
		//System.out.println(str.equals(build.toString()));
		
		str.concat("Hello");
		buff.append(" Hello");
		build.append(" Hello");
		
		System.out.println(str + " " + buff + " " + build);
		
		

	}
		static String stringthings(String s){
			
			return s.concat(" world/");
		}
}
