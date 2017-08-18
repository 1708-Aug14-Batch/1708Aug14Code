package com.WeekOneHW.QuestionTen;

import java.util.*;

public class TernaryTest {

	public static void main(String[] args) {
		/*
		 * This program uses a scanner to get user input for 2 numbers.
		 * Then a value is set to the minimum after running a ternary operator. It's then outputted.
		 */
		Scanner input = new Scanner(System.in);
		int num1, num2;
		System.out.println("Enter the first number: ");
		num1 = input.nextInt();
		System.out.println("Enter the second number: ");
		num2 = input.nextInt();
		
		int minValue = minValue(num1,num2);
		System.out.println(minValue);

	}
	
	public static int minValue(int num1, int num2) {
		
		return (num1<num2) ? num1 : num2;
	}

}
