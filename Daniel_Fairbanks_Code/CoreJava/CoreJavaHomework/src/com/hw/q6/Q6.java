package com.hw.q6;

import java.util.Scanner;

public class Q6 {

	public static boolean is_even(int num)
	{
		if ((num & 1) == 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value to check if it's even or odd.");
		int n;
		while (true)
		{
			try {
				String line = scanner.nextLine();
				n = Integer.parseInt(line);
				break;
			} catch (Exception e) {
				System.out.println("User must enter an integer. Please try again...");
			}
		}
		scanner.close();
		if (is_even(n))
			System.out.println("The number "+n+" is even.");
		else
			System.out.println("The number "+n+" is odd.");
	}

}
