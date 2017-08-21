package com.ex.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		
		//user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("What would you like to do? (1 for the square root of a number, 2 for today's date, and 3 for splitting a pre-defined string)");
		int userInput = s.nextInt();
		
		//evaluating the user's choice
		switch(userInput)
		{
		//find square root if selected 1
		case 1:
			System.out.println("Enter number to find square root: ");
			int num = s.nextInt();
			System.out.println(Math.sqrt(num));
			break;
		//say date if selected 2
		case 2:
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date d = new Date();
			System.out.println(df.format(d));
			break;
		//split a string if selected 3
		case 3:
			String str = "I am learning core java!";
			String[] parts = str.split(" ", 0);
			for(String e:parts)
			{
				System.out.println(e);
			}
			
			break;
			
		}
		
		
		s.close();
	}

}
