package com.hw.q14;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int val = 0;
		while (val != 1 && val != 2 && val != 3)
		{
			System.out.println("Enter the value 1, 2, or 3.");
			try {
				String line = scanner.nextLine();
				val = Integer.parseInt(line);
			} catch (Exception e) {
				System.out.println("User must enter an integer. Please try again...");
			}
		}
		scanner.close();
		
		switch(val) {
		case 1:
			int n = 16;
			System.out.println("The square root of "+n+" equals "+Math.sqrt(n));
			break;
		case 2:
			Date dNow = new Date( );
		    SimpleDateFormat ft = 
		    new SimpleDateFormat ("E MM/dd/yyyy");
		    System.out.println("Current Date: " + ft.format(dNow));
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] ary = str.split(" ");
			for (String s: ary)
				System.out.println(s);
			break;
		}
	}
}
