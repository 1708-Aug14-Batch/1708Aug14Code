package com.ex.question16;
import java.util.Scanner;

public class StringCommandLine {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String: ");
		args[0] = s.nextLine();
		
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
