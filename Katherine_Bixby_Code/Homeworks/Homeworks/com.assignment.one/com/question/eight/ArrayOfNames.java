package com.question.eight;

import java.util.ArrayList;

/**
 * Manipulates a String of names separated by commas and stores them into an array of names
 * Takes that array and can also generate an array of names that are palindromes.
 * 
 * @author Katie
 *
 */

public class ArrayOfNames {
	
	public static ArrayList<String> nameList;	// the list of names
	public static ArrayList<String> palNames;	// the list of names that are palindromes
	
	
	/**
	 * Takes in a String containing names separated by commas
	 * Splits the String by using the comma as a deliniator.
	 * Then stores each of those names in nameList.
	 * @param theNames
	 * 		The String containing all the names to be analyzed, separated by commas.
	 */
	public static void cutStringOfNames(String theNames){
		String[] nameListStr = theNames.split(",");	// split by comma
		String tempStr = "";
		nameList = new ArrayList<String>();
		palNames = new ArrayList<String>(); // make sure bothh arrays exist
		for (int i=0;i<nameListStr.length;i++) {
			if(nameListStr[i]!=null) {
				tempStr = nameListStr[i]; // add those names to the ArrayList of names
				nameList.add(tempStr);
			}
		}
	}
	
	/**
	 * Gets the palindrome names within the nameList and proppogates palNames with
	 * all of the names that contain palindromes
	 */
	public static void palindromeNames(){
		
		for(int i=0;i<nameList.size();i++) {
			if(isPalindrome(nameList.get(i))) {
				palNames.add(nameList.get(i));
			}
		}
	}
	
	/**
	 * Checks if a name is a palindrome
	 * @param name
	 * 		Name to check
	 * @return
	 * 		Whether or not that name is a palindrome
	 */
	private static boolean isPalindrome(String name) {
		int n = name.length();
		for (int i=0;i<(n/2);++i) {	// checks opposite letters (front and back) and sees if they're same
			// if name has odd number of letters it just doesn't check the middle, but that
			//would still be a palindrome
			if (name.charAt(i)!=name.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Print out an array
	 * @param toPrint
	 * 		The array to be printed
	 */
	public static void printArray(ArrayList<String> toPrint) {
		for(int i=0;i<toPrint.size()-1;i++) {
			System.out.print(toPrint.get(i)+", ");
		}
		System.out.print(toPrint.get(toPrint.size()-1));
		System.out.println("");
	}
	
}
