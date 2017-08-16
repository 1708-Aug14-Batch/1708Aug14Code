package com.WeekOneHW.QuestionEight;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		/*
		 * Setting up the Array and ArrayLists used.
		 * The first Array, temp, is used to store the values that will be later transfered to list.
		 * The first ArrayList, list, will store all the values
		 * The second ArrayList, palindrome, will store the palindromes after being sent through the isPalin function
		 */
		String[] temp = {"karen", "madam", "tom", "civic", "radar", "sexes", "jimmy"
		 				,"kayak", "john", "refer", "billy", "did"};
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> palindrome = new ArrayList<String>();
		
		for(int i = 0; i <= temp.length - 1; i++) //For loop to fill list with the values from temp.
			list.add(temp[i]);
		
		for(int i = 0; i <= list.size() -1; i++) { //For loop that steps through list and runs each value through isPalin
			if(isPalin(list.get(i))) {
				palindrome.add(temp[i]); //If isPalin is true, add to the palindrome list
			}
		}
		
		//Outputs the lists
		System.out.print(list);
		System.out.print("\n" + palindrome);
	}
	static boolean isPalin(String str) { //isPalin function that takes a string as an argument
		char[] forward = str.toCharArray(); //Create a char array with the string sent down.
		int counter = 0; //Counter variable which is used as the mirror element to compare to the regular element
		for(int i = forward.length - 1; i >= 0; i--) { //For loop stepping through the char array
			if(forward[i] != forward[counter]) { //If the i value does not match the counter value(which mirrors it)
				return false; 
			}
			counter++; //Increment the counter value to continue mirroring
		}
		return true; //If it gets to this point it returns true and adds to the palindrome ArrayList.
	}
}
