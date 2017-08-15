package com.hw.q8;
import java.util.ArrayList;

public class Q8 {

	public static String get_palindrome(String word)
	{
		StringBuilder sb = new StringBuilder(word).reverse();
		if (word.equals(sb.toString()))
				return sb.toString();
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String w : words)
		{
			String rev = get_palindrome(w);
			if (rev != null)
			{
				palindromes.add(get_palindrome(w));
				System.out.println(rev);
			}
		}
	}

}
