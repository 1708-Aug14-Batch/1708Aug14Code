package com.ex.strings;

public class StringBuilderAndBuffer {
	static int x = 8; //instance scope

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		System.out.println(str.equals(buff));
		System.out.println(str.equals(build));
		System.out.println(build.equals(buff));

		System.out.println(buff.toString().equals(str));
		System.out.println(buff.toString() == str);
		
		buff.append("world/");
		//doThings(str);
		x= 5;
		
		int x = 3;
		if(x==3 & x==4) {
			System.out.println("True");
		}
		
	}
	
	public int doThings(String different){//method scope
		different = "hello";
		x = 7;
		
		return 0;
	}
	

}
