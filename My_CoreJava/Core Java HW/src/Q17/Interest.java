package Q17;

import java.util.Scanner;

public class Interest {
	
	public static float calcInterest(float principal, float rate, float time) {
		return principal * rate * time;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the principal amount: ");
		float principal = scan.nextFloat();
		
		System.out.println("Enter the rate as decimal: ");
		float rate = scan.nextFloat();
		
		System.out.println("Enter amount of time in years: ");
		float time = scan.nextFloat();
		
		System.out.println("The interest is " + calcInterest(principal, rate, time));
	}
}
