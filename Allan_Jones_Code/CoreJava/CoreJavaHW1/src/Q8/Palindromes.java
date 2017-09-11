package Q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {
	// Write a program that stores the following strings in an ArrayList
	// and saves all the palindromes in another ArrayList.
	//
	//	“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
	
	static ArrayList<String> initStr = new ArrayList();
	static ArrayList<String> palinStr = new ArrayList();
	
	public static void main(String[] args) {
		initStr.add("karan");
		initStr.add("madam");
		initStr.add("tom");
		initStr.add("civic");
		initStr.add("radar");
		initStr.add("sexes");
		initStr.add("jimmy");
		initStr.add("kayak");
		initStr.add("john");
		initStr.add("refer");
		initStr.add("billy");
		initStr.add("did");
		
		System.out.println("The initial list");
		System.out.println(initStr);
		isPalindrome();
	}
	
	public static void isPalindrome() {
		for(String s:initStr) {
			String r = "";  // holds the reverse of the initStr
			int len = s.length();
			for(int i = len - 1; i >= 0; i--) {
				r = r + s.charAt(i);
			}
			if(s.equals(r)) {
				palinStr.add(r);
			}
		}
		System.out.println();
		System.out.println("The Palindrome list");
		System.out.println(palinStr);
	}
}
