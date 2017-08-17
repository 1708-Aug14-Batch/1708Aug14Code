package com.ex.question8;

import java.util.ArrayList;

public class Palindromes {
	
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listPalindromes = new ArrayList<String>();
		
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
		for(String s:list)
		{
			String temp = reverse(s);
			if(temp.equals(s))
				listPalindromes.add(s);
		}
		
		for(String s:listPalindromes)
		{
			System.out.println(s);
		}

	}
	
	static String reverse(String str)
	{
		if(str.length() == 0 || str.length() == 1) return str;
		
		return str.charAt(str.length()-1) + reverse(str.substring(1, str.length()-1)) +str.charAt(0);
	
	}

}
