package com.ex.Q5;

public class Q5 {

	public static void main(String[] args) {
		String str = "test";
		reverse(str);
	}
	
	public static String reverse(String str ){
		
		
		if(str.length()==0 || str.length()==1) return str;

		String temp = str.charAt(str.length()-1)+
				reverse(str.substring(1,str.length()-1))
		+ str.charAt(0);
		
		System.out.println(temp);

		return temp;
	}
}
