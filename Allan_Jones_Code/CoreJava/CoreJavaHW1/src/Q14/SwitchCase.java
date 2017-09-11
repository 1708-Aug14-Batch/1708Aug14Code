package Q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchCase {
	// Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	// Case 1: Find the square root of a number using the Math class method.
	// Case 2: Display today’s date.
	// Case 3: Split the following string and store it in a sting array.
	//         “I am learning Core Java”
	
	public static boolean answ;
	
	public static void main(String[] args) {
		answ = true;
		Scanner scan = new Scanner(System.in);
		while(answ) {
			System.out.println("Enter a number 1, 2, or 3 (any other number to exit)");
			int num = scan.nextInt();
			switch(num) {
			case 1:
				findSQRT();
				break;
			case 2:
				todaysDate();
				break;
			case 3:
				storeString();
				break;
			default:
				System.out.println("Wrong number, bye");
				answ = false;
			}
		}
	}

	public static void findSQRT() {
		int i = 9;
		int square = (int) Math.sqrt(i);
		System.out.println("The square root of 9 is: " + square);
		System.out.println();
	}
	
	public static void todaysDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println("Today's date is: " + dtf.format(localDate));
		System.out.println();
	}
	
	public static void storeString() {
		String str1 = "I am learning Core Java";
		String[] splitStr = str1.split(" ");
		System.out.println("These are the Strings in the Array");
		for(String s:splitStr) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
