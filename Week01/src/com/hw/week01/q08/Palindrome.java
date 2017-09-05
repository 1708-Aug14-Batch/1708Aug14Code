package com.hw.week01.q08;

import java.util.ArrayList;

public class Palindrome {
	
	public static ArrayList<String> returnPalindromes(ArrayList<String> strings) {
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String currentString : strings) {
			if(currentString.equals(new StringBuilder(currentString).reverse().toString())) {
				palindromes.add(currentString);
			}
		}
		return palindromes;
	}

}
