package Q12;

import java.util.Scanner;

public class ThisMainClass {
	public static void main(String[] args){
		new ThisMainClass();
	}
	
	public ThisMainClass(){
		ThisSubClass haveMethods =new ThisSubClass();
		Scanner input = new Scanner(System.in);
		System.out.println("1.	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.");
		System.out.println("2.	Convert all of the lower case characters to uppercase in the input string, and return the result. ");
		System.out.println("3.	Convert the input string to integer and add 10, output the result to the console.");
		int user = input.nextInt();
		input.nextLine();
		
		switch(user){
		case 1: {
			System.out.println("enter a string to look for upper case");
			String str = input.nextLine();
			System.out.println(haveMethods.checkCaps(str));
		}break;
		case 2: {
			System.out.println("enter a string to convert to upper case");
			String str = input.nextLine();
			System.out.println(haveMethods.makeCap(str));
		}break;
		case 3: {
			System.out.println("enter a string to add 10");
			String str = input.nextLine();
			System.out.println(haveMethods.makeIntAdd(str));
		}break;
		default:{
			System.out.println("Wrong choice does not exist");
		}break;
		}
	}
}
