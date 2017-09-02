package question5;

import java.util.Scanner;

/*
 * Q5. Write a substring method that accepts a string str and an integer idx
 * and returns the substring contained between 0 and idx-1 inclusive.  Do NOT
 * use any of the existing substring methods in the String, StringBuilder, or
 * StringBuffer APIs.
 */

public class SubstringBuilder {

	public static void main(String[] args) {

		// Take input from the user
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a string to be substringed: ");
		String str = scan.nextLine();
		System.out.println("Enter an index for the substringing: ");
		String index = scan.nextLine();

		// Attempt to cast to an integer
		try {
			int idx = Integer.parseInt(index);

			System.out.println(subStringer(str, idx));
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: That is not an index");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Invalid input: That index is longer than the provided string");
		}

		scan.close();
	}

	// Returns a substring of str from index 0 to idx-1
	public static String subStringer(String str, int idx) {
		if (str == null)
			return null;
		if (idx > str.length())
			return str;
		
		String result = "";

		// Keep each char up to idx-1
		for (int i = 0; i < idx; i++)
			result += str.charAt(i);

		return result;
	}
}