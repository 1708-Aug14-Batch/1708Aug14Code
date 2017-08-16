package problem14;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Problem14 {
	//Q14. Write a program that demonstrates the switch case. 
	//Implement the following functionalities in the cases:
	//Case 1: Find the square root of a number using the Math class method. 
	//Case 2: Display today’s date.
	//Case 3: Split the following string and store it in a string array. 
	//		“I am learning Core Java”


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// User input 1,2,3

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1,2,or 3");
		
		int input = scan.nextInt();
		
		// Switch statements for each case
		
		switch(input) {
		case 1: // Calc sqrt of user input
			System.out.println("Enter a number to find the sqrt");
			input = scan.nextInt();
			System.out.println("Sqrt of "+input+" is " + Math.sqrt(input));
			break;
		case 2: // Outputs the date
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String today = sdf.format(date);
			
			System.out.println("Today's date is " + today);
			break;
		case 3: // Splits the string into a string array
			String string = new String("I am learning Core Java");
			String strArr[] = string.split(" ");
			System.out.println(Arrays.toString(strArr));
		}
		
	}

}
