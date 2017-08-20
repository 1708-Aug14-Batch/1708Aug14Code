package questionSeventn;

import java.util.Scanner;

public class Interest {
	
	private Scanner scan;
	
	public double interest() {
		scan = new Scanner(System.in);
		
		//asks for and retrieves principal
		System.out.println("Enter principal:");
		double principal = scan.nextDouble();
		//asks for and retrieves interest rate
		System.out.println("Enter interest rate:");
		double rate = scan.nextDouble();
		//asks for and retrieves time
		System.out.println("Enter time:");
		double time = scan.nextDouble();
		//calculates interest
		double interest = principal*rate*time;
		//returns interest
		return interest;
	}

}
