package com.question.eight;

import java.util.ArrayList;

public class ArrayOfNames {
	
	public static ArrayList<String> nameList;
	public static ArrayList<String> palNames;
	
	
	
	public static void cutStringOfNames(String theNames){
		String[] nameListStr = theNames.split(",");
		String tempStr = "";
		nameList = new ArrayList<String>();
		palNames = new ArrayList<String>();
		for (int i=0;i<nameListStr.length;i++) {
			if(nameListStr[i]!=null) {
				tempStr = nameListStr[i];
				nameList.add(tempStr);
			}
		}
	}
	
	//public static ArrayList<String> arrOfNames = new ArrayList<String>();
	public static void palindromeNames(){
		
		for(int i=0;i<nameList.size();i++) {
			if(isPalindrome(nameList.get(i))) {
				palNames.add(nameList.get(i));
			}
		}
	}
	private static boolean isPalindrome(String name) {
		int n = name.length();
		for (int i=0;i<(n/2);++i) {
			if (name.charAt(i)!=name.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(ArrayList<String> toPrint) {
		for(int i=0;i<toPrint.size()-1;i++) {
			System.out.print(toPrint.get(i)+", ");
		}
		System.out.print(toPrint.get(toPrint.size()-1));
		System.out.println("");
	}
	
}
