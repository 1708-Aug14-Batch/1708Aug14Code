package Q3;

public class Reverse {
	
	/**
	 * Reverses the order of characters in an input string
	 * @param str The string to be reversed
	 * @return A new string containing the input characters in reverse order
	 */
	public static String reverse(String str) {
		char[] ret = new char[str.length()];
		
		int i = 0;
		for (char c : str.toCharArray()) {
			// Put characters from string into character array in reverse order
			ret[str.length()-1-i++] = c;
		}
		
		return new String(ret);
	}
	
	public static void main(String[] args) {
	
		String s = ".esrever ni si sihT";
		
		System.out.println(s);
		
		s = reverse(s);
		
		System.out.println(s);
	}
}