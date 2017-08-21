package com.ex.question5;

public class Substring {

	public static void main(String[] args) {;
		
		System.out.println(substring("Revature",3));
		
	}
	
	//method to print out a substring from 0 to the index
	static String substring(String str, int idx)
	{
		char[] chars = str.toCharArray();
		String result = "";
		for(int i = 0; i<=idx; i++)
		{
			result += chars[i];
		}
		return result;	
	}

}
