package com.questionFive;

public class question5 {
	static String subStringMethod(String str, int idx) {

		char[] myArray = str.toCharArray();
		char[] mySecondArray = new char[idx];
		for(int i = 0; i < mySecondArray.length; i++) {
			mySecondArray[i] = myArray[i];
		}
		String myString = String.valueOf(mySecondArray);
		//System.out.println(myString);
		
		return myString;
	}
	public static void main(String[] args) {
		String string = subStringMethod("asdfghjkl", 6);
		System.out.println(string);
		
	}
}
