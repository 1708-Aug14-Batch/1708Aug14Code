package question.fourteen;

import java.util.Date;
import java.util.Scanner;

public class SwitchExamples {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int num = 0, num2;
		String input = "I am learning Core Java";
		Date today = new Date();
		
		System.out.println("Choose what you want to do:");
		System.out.println("1 - perform the square root of a number");
		System.out.println("2 - display today's date");
		System.out.println("3 - split a string and store it");
		num = in.nextInt();
		
		switch(num) {
		case 1: System.out.println("Enter a number to take the square root of:");
				num2 = in.nextInt();
				System.out.println("The sqrt of " + num2 + " is " + Math.sqrt(num2));
				break;
		case 2: System.out.println(today);
				break;
		case 3: System.out.println(input);
			    String[] arr = input.split(" ");
			    for (String x: arr) {
			    	System.out.println(x);
			    }
				break;
		}
	}

}
