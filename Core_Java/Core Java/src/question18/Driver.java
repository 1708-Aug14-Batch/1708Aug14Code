package question18;

import java.util.Scanner;

/*
 * Q18. Write a program having a concrete subclass that inherits three
 * abstract methods from a superclass.  Provide the following three
 * implementations in the subclass corresponding to the abstract
 * methods in the superclass: 

1.	Check for uppercase characters in a string, and return ‘true’ or
‘false’ depending if any are found.
2.	Convert all of the lower case characters to uppercase in the
input string, and return the result. 
3.	Convert the input string to integer and add 10, output the result
to the console.
Create an appropriate class having a main method to test the above setup.

 */

public class Driver {
	
	public static void main(String[] args) {
		StringChecker check = new StringChecker();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		
		String str = scan.nextLine();
		
		System.out.println(check.hasUppercase(str));
		System.out.println(check.lowercaseTouppercase(str));
		check.printIntegerFromString(str);
		
		scan.close();
	}

}
