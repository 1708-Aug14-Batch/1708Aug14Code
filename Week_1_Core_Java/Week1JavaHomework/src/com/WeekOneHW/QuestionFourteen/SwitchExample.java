package com.WeekOneHW.QuestionFourteen;

import java.time.LocalDate; //Importing this to call the LocalDate function for case 2
import java.util.*; //Importing in to create the scanner


public class SwitchExample {

	public static void main(String[] args) {
		int choice = 0; //Variable used to get user chocie to run through the switch

		Scanner input = new Scanner(System.in); //Creating the scanner
		
		System.out.println("Enter a choice to run: "); //Gets the user input
		choice = input.nextInt();
		
		switch(choice) { //Begin the switch case based of user input
		case(1): //Case 1 gets the user to input a number then output the square root using the number.
			int num;
		System.out.println("Enter a number to get a square root: ");
		num = input.nextInt();
		System.out.println(Math.sqrt(num));
		break;
		
		case(2): //Case 2 uses a LocalDate object to print out the current date.
			LocalDate todayDate = LocalDate.now();
		System.out.println(todayDate);
		break;
		
		case(3): //Case 3 takes the string and splits its into an array using the spaces. Then it outputs each element in the array
			String str = "I am learning Core Java";
		String[] arr = str.split(" ");
		for(int i = 0; i <= arr.length - 1; i++)
			System.out.println(arr[i]);
		break;
		default:
			break;
		}
		
	}

}
