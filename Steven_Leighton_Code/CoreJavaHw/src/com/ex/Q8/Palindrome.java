package com.ex.Q8;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

	public static void main(String[] args) {
		List<String> strings= new ArrayList<String>();
		List<String> palindromes= new ArrayList<String>();
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		
		for(String s : strings){
			if(isPalindrome(s)){
				System.out.println(s);
				palindromes.add(s);
			}
		}
		
		
	}

	static boolean isPalindrome(String s){
		if(s.length() == 0) return false;
		if(s.length() == 1) return true;
		for(int i=0; i < s.length() / 2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
		}
		
		return true;
	}
}
