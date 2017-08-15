package homework.question.five;

import java.util.*;

public class QuestionFive {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.");
		System.out.println("Type in a string of your choice.");
		String input = scan.nextLine();
		System.out.println("Type in where you would like the substring to end at");
		int substringPosition = scan.nextInt();
		System.out.println(retrieveSubstring(input, substringPosition));
	}

	public static String retrieveSubstring(String input, int position) {
		try {
			String inputSubstring = "";

			for (int i = 0; i < position; i++) {
				inputSubstring += input.charAt(i);
			}

			return inputSubstring;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}

		return null;
	}
}
