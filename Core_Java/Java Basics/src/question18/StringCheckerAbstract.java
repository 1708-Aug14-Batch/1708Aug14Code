package question18;

/*
 * 1. Check for uppercase characters in a string, and return ‘true’ or
 * 		‘false’ depending if any are found.
 * 2. Convert all of the lower case characters to uppercase in the
 * 		input string, and return the result. 
 * 3. Convert the input string to integer and add 10, output the result
 * 		to the console.
 */

public abstract class StringCheckerAbstract {
	
	// Return true if str has uppercase characters
	abstract boolean hasUppercase(String str);
	
	// Convert only lowercase characters to uppercase in str. Return result
	abstract String lowercaseTouppercase(String str);
	
	// Converts str to an integer, adds 10, prints result to the console
	abstract void printIntegerFromString(String str);

}
