package problem8;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem8 {
	//Q8. Write a program that stores the following strings in an ArrayList 
	//and saves all the palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, 
	//“kayak”, “john”,  “refer”, “billy”, “did”


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String strings[] = {"karan", "madam", "tom", "civic", "radar", "sexes", 
				"jimmy", "kayak", "john",  "refer", "billy", "did"};
		
		ArrayList<String> arrList = new ArrayList<>();
		ArrayList<String> palindromeList = new ArrayList<>();
		
		// Loop through the string array
		
		for(String x:strings) {
			int startLetter = 0;
			int endLetter = x.length()-1;
			boolean palin = true;
			// Loop through the letters and compare
			
			for(int i = 0; i<x.length()/2;i++) {
				if(x.charAt(startLetter)!=x.charAt(endLetter)) {
					palin = false;
					break;
				}
			}
			
			if(palin == true) {
				palindromeList.add(x);
			}
			else{
				arrList.add(x);
			}
		}
		
		System.out.println("Palindrome List: " + palindromeList);
		System.out.println("Non Palindrome List: " + arrList);
	}

}
