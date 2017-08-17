package Q5;

import java.util.Arrays;

public class SubString {
/*
 * Write a substring method that accepts a string str and an integer idx and returns the substring
 *  contained between 0 and idx-1 inclusive. Do NOT use any of the existing substring methods
 *  in the String, StringBuilder, or StringBuffer APIs.
 */
	static String subStr;
	
	public static void main(String[] args) {
		try {
			subStr = subString("Jesse", 2);
			System.out.println(subStr);
			subStr = subString("Allan", 4);
			System.out.println(subStr);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public static String subString(String str, int idx) {
		char[] chrArray = str.toCharArray();
		String subStr = "";
		for(int i = 0; i < idx; i++) {
			if(idx > chrArray.length) {
				break;
			}
			subStr += chrArray[i];
		}
		return subStr;
	}
}
