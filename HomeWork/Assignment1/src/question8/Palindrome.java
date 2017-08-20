package question8;

import java.util.ArrayList;


/**
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

 * @author josh wurdemann
 * 
 */
public class Palindrome {
	public static void sortPalindromes(ArrayList<String> panlindrome, ArrayList<String> list) {
		
		for(String s: list){
			if(isPalindrome(s) == true){
				panlindrome.add(s);
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		/**if length is 0 or 1 then String is palindrome*/
		if(s.length() == 0 || s.length() == 1){
			return true; 
		}
		if(s.charAt(0) == s.charAt(s.length()-1)){
			/** check for first and last char of String:
			 * if they are same then do the same thing for a substring
			 * with first and last char removed. and carry on this
			 * until you string completes or condition fails
			 * Function calling itself: Recursion
			 */
			return isPalindrome(s.substring(1, s.length()-1));
		}
			/** the String is not palindrome hence return false.
			 */
			return false;
		}
		public static void printList(ArrayList<String> palindrome, ArrayList<String> list){
			for(String s: list){
				System.out.print(s + ": ");
			}
			for(String x: palindrome){
				System.out.println(x);
			}
		}
		
	public static void main(String[] args) {
		ArrayList<String> panlindrome = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
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
		sortPalindromes(panlindrome, list);
		printList(panlindrome, list);
		

		}
}