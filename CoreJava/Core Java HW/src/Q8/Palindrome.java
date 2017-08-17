package Q8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Palindrome {
	
	public static List<String> getPalindromes(List<String> words) {
		List<String> ret = new ArrayList<>();
		
		for (String s : words) {
			char[] word = s.toCharArray();
			boolean isPalin = true;
			
			for (int i = 0; i < s.length() / 2; i++) {
				if (word[i] != word[s.length()-1-i]) {
					isPalin = false;
				}
			}
			if (isPalin) {
				ret.add(s);
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>();
		
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
		
		for (String s : words) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		List<String> palindromes = getPalindromes(words);
		
		for (String s : palindromes) {
			System.out.print(s + ", ");
		}
	}
}
