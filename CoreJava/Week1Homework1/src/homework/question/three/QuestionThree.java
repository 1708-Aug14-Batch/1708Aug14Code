package homework.question.three;

public class QuestionThree {

	public static void main(String[] args) {
		System.out.println(
				"Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.");
		System.out.println(reverseString("alvin lu"));

	}

	public static String reverseString(String input) {

		for (int i = 0; i < input.length(); i++) {
			input = input.substring(1, input.length() - i) + input.substring(0, 1)
					+ input.substring(input.length() - i, input.length());

		}

		return input;
	}

}
