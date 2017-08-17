package com.ex.question13;

public class TriangleOnConsole {

	public static void main(String[] args) {

		String str= "0101010101";
		int x = 0;
		for(int i = 0; i<str.length();i++)
		{
			for(int j= 0; j <=i; j++)
			{
				System.out.print(str.charAt(x) +" ");
				x++;
			}
			if(x == str.length())
				break;
			System.out.println();
		}		

	}

}
