package Q5;

public class Substring {
	
	/**
	 * Finds substring from index 0 to i exclusive
	 * @param str Input string
	 * @param i Upper bound
	 * @return Substring in range (0, i)
	 */
	public static String substring(String str, int i) {
		// Return unchanged string if range is larger than length
		if (str.length() <= i) return str;
		
		char[] ret = new char[i];
		for (int j = 0; j < i; j++) {
			ret[j] = str.toCharArray()[j];
		}
		return new String(ret);
	}
	
	public static void main(String[] args) {
		
		String str = "000000000000x";
		System.out.println(substring(str, 12));
	}

}
