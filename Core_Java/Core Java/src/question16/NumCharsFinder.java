package question16;

/*
 * Q16. Write a program to display the number of characters for a
 * string input. The string should be entered as a command line
 * argument using (String [ ] args).
 */

public class NumCharsFinder {
	
	public static void main(String[] args) {
		
		try {
			String str = args[0];
			System.out.println("The following is the entered string: ");
			System.out.println(str);
			System.out.println("This string has " + str.length() + " characters in it");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: This program requires a string input given through the command line");
		}
	}

}
