package question.seventeen;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		double interest = 0;
		double principal = 0;
		double rate = 0;
		double time = 0;
		
		System.out.println("This will calculate the interest after being provided the principal, rate, & time.");
		System.out.println("Please enter a prinicpal:");
		principal = in.nextDouble();
		System.out.println("Please enter a rate:");
		rate = in.nextDouble();
		System.out.println("Please enter a time:");
		time = in.nextDouble();
		
		interest = principal * rate * time;
		
		System.out.println("The interest is: " + interest);

	}

}
