package problem16;

import java.util.Scanner;

public class Problem16 {
	//Q16. Write a program to display the number of characters for a string input. 
	//The string should be entered as a command line argument using (String [ ] args).
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter string");
		
		String input = scan.nextLine();
		
		System.out.println(input.length());

	}

}
