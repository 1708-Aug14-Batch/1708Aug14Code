package com.ex.day2;

public class StringBufferAndBuilder {
	
	/*
	 * variable scopes:
	 * local aka method
	 * block aka loop
	 * member aka class
	 *  
	 */
	
	//static scope belongs to the class
	static int stat = 10;
	
	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		System.out.println(str.equals(buff));
		System.out.println(str.equals(build));
		
		System.out.println(str.equals(buff.toString()));
		System.out.println(str.equals(build.toString()));
		
		System.out.println(str == buff.toString());
		System.out.println(str == build.toString());
		
		str.concat(" world/");
		buff.append(" world/");
		build.append(" world/");
		
		System.out.println(str + " " + buff + " " + build);
		
		//str = stringThings(str);
		//buff = buffThings(buff);
		//build = buildThings(build);
	}
	
	//static String stringThings(String s) {
		
	//}
	
	static String doThings(String different) { //different is a method scope variable
		different ="hellor ossejfl";
		String anotherone= "ajsfjlg";
		//x = 10;
		
		return null;
	}

}
