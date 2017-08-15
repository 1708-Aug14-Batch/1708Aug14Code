package com.WeekOneHW.QuestionFive;

import java.util.*; //Importing in the scanner

public class SubstringMethods {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = new String();
		int idx = 0;
		System.out.println("Enter a string: ");
		str = input.nextLine();
		System.out.println("Enter the length of the substring you wish to return: ");
		idx = input.nextInt();
		StringBuilder newSubString = subStringMethod(str,idx);
		System.out.println(newSubString);
		
	}
	
	static String subStringMethod(String str, int idx) {

		char[] arr = str.toCharArray();
		for(int i = 0; i <= idx-1; i++) {
			
		}
		
		return null;
	}
}
