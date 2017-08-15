package com.ex.string;

public class Stringbuilder {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer ("hello");
		StringBuilder build = new StringBuilder ("hello");
		
//		System.out.println(str.equals(buff));
//		System.out.println(str.equals(build));
//		System.out.println(buff.equals(build));

		str.concat(" world/");
		buff.append(" world/");
		build.append(" world/");
		
		System.out.println(str);
		System.out.println(buff);
		System.out.println(build);
		
	}
	
	static String doThings(String str) {
		
		return null;
	}
	
}
