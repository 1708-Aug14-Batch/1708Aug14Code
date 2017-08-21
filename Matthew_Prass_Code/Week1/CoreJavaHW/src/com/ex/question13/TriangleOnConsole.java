package com.ex.question13;

public class TriangleOnConsole {

	public static void main(String[] args) {

		
		//string to print out in triangle
		String str= "0101010101";
		int x = 0;
		
		//nested for loop to make a triangle(similar to how you would iterate through 2D array)
		for(int i = 0; i<str.length();i++)
		{
			for(int j= 0; j <=i; j++)
			{
				//print out a character and a space
				System.out.print(str.charAt(x) +" ");
				x++;
			}
			//stop once you have reached the end
			if(x == str.length())
				break;
			System.out.println();
		}		

	}

}
