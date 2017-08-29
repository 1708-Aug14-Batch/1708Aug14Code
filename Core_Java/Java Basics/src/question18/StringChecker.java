package question18;

public class StringChecker extends StringCheckerAbstract {

	// Return true if str has uppercase characters
	@Override
	boolean hasUppercase(String str) {
		for (Character cha : str.toCharArray())
			if (Character.isUpperCase(cha))
				return true;
		return false;
	}

	// Convert only lowercase characters to uppercase in str. Return result
	@Override
	String lowercaseTouppercase(String str) {
		char[] chaArray = str.toCharArray();
		
		// Change lowercase characters to uppercase
		for (int i = 0; i < chaArray.length; i++)
			if (Character.isLowerCase(chaArray[i]))
				chaArray[i] = Character.toUpperCase(chaArray[i]);
		
		// Format return value to a String
		String result = "";
		for (char cha : chaArray)
			result += cha;
		
		return result;
	}

	// Converts str to an integer, adds 10, prints result to the console
	@Override
	void printIntegerFromString(String str) {
		int result = 0;
		
		// Convert str to an integer
		for (char cha : str.toCharArray())
			result += cha;
		
		System.out.println(result + 10);
	}
	
}
