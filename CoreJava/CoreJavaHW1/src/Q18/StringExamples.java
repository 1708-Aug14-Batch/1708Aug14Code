package Q18;

public class StringExamples extends AbsStrings {
	// Write a program having a concrete subclass that inherits three abstract methods from a superclass.
	// Provide the following three implementations in the subclass corresponding to the abstract methods
	// in the superclass:
	// 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	// 2. Convert all of the lower case characters to uppercase in the input string, and return the result.
	// 3. Convert the input string to integer and add 10, output the result to the console.
	
	public static void main(String[] args) {
		String s = "I love Java Core programming";
		String num = "15";
		StringExamples strEx = new StringExamples();
		System.out.println(strEx.isUpper(s));
		System.out.println(strEx.toUpper(s));
		System.out.println(strEx.toInteger(num));

	}

	@Override
	boolean isUpper(String s) {
		boolean bool = false;
		for(int i = 0; i < s.length(); i++) {
			bool = Character.isUpperCase(s.charAt(i));
			if(bool) {
				break;
			}
		}
		return bool;
	}

	@Override
	int toInteger(String s) {
		return Integer.parseInt(s) + 10;
	}

	@Override
	String toUpper(String s) {
		boolean bool = false;
		String str = "";
		for(int i = 0; i < s.length(); i++) {
			bool = Character.isUpperCase(s.charAt(i));
			if(bool) {
				str = str + s.charAt(i); 
			} else {
				str = str + Character.toUpperCase(s.charAt(i));
			}
		}
		return str;
	}

}
