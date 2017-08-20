package question14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
Case 1: Find the square root of a number using the Math class method. 
Case 2: Display today’s date.
Case 3: Split the following string and store it in a sting array. 
		“I am learning Core Java”

 * @author josh wurdemann
 * @version 8/20/2017
 */
public class SwitchCase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to SwitchCase How can I direct you?");
		System.out.println("Enter choice: (1)Find the square root of a number ");
		System.out.println("Enter choice: (2)Display today’s date.");
		System.out.println("Enter choice: (3)Split the following string and store it in a sting array." +
				"I am learning Core Java");
		int input = scan.nextInt();

		switch (input){

		case(1) :
			System.out.print(" Please enter a number");
		int number = scan.nextInt();
		number = (int) Math.sqrt(number);
		System.out.println(number);
		break;
		case(2) : 
			LocalDateTime timePoint = LocalDateTime.now();
			LocalDate theDate = timePoint.toLocalDate();
			System.out.println("Todays Date:" + theDate);
			break;
		case(3) :
			String phrase = "I am learning Core Java";
			
		String []stringArray = phrase.split("");
		for(String s: stringArray){
		System.out.print(s);
		}
			break;
		}
		scan.close();
	}

}
