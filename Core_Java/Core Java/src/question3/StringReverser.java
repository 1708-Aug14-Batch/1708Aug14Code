package question3;

/* 
 * Q3 Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */

public class StringReverser {

	private static String inputString = "Hello World!";
	
	public static void main(String[] args) {
		char chars[] = reverseString(inputString);
		
		for (char c : chars)
			System.out.print(c);
		System.out.println();
	}
	
	public static char[] reverseString(String inputString) {
		if (inputString == null)
			return null;
		
		// Move the string to an arary of chars for easy modification
		char[] chars = inputString.toCharArray();
		
		// Keep track of two indexes used for swapping characters
		// one for the front of the string, one for the back
		int index1 = 0, index2 = inputString.length()-1;
		
		// Because the following loop checks whether index1 is strictly
		// less than index 2 it should handle cases for both even-length
		// and odd-length strings
		/*
		 * Using a temporary variable would make this far easier.
		 * This solution will be tricky.
		 * Two characters will be selected for swapping: a and b
		 * Each character will be treated as a integer
		 * Three modifications will be applied to the pair of integers
		 * 1. the value of b is added to a
		 * 2. The new value of a is subtracted from b, then the sign of b is reversed
		 * 		This gives b the original value of a
		 * 3. The new value of b is subtracted from the new value of a
		 * 		This gives a the original value of b
		 */
		while (index1 < index2) {
			// char a has the value chars[index1]
			// char b has the value chars[index2]
			
			// Step 1: a = a + b
			chars[index1] = (char)(chars[index1] + chars[index2]);
			
			// Step 2: b = -(b - a)
			chars[index2] = (char)(Math.negateExact(chars[index2] - chars[index1]));
			
			// Step 3: a = a - b
			chars[index1] = (char)(chars[index1] - chars[index2]);
			
			// Update the indexes
			index1++;
			index2--;
		}
		
		return chars;
	}
}
