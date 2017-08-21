package com.ex.question16;
import java.util.Scanner;

public class StringCommandLine {

	public static void main(String[] args) {
		
		
		//user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String: ");
		
		//command line arguments
		args[0] = s.nextLine();
		
		
		//printing out number of characters in the user input
		char[] chars = args[0].toCharArray();
		int numOfChars = 0;
		for(char c: chars)
		{
			numOfChars++;
		}
		System.out.println(numOfChars);
		
		s.close();
	}

}
