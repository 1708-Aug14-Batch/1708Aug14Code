package com.hw.q4;
import java.util.Scanner;

public class Q4 {

	public int compute_factorial(int val)
	{
		if (val == 1)
			return 1;
		return val * compute_factorial(val-1);
	}
	
	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value to compute its factorial.");
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
		System.out.println(compute_factorial(n));*/
	}

}
