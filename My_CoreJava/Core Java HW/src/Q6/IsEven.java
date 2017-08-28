package Q6;

public class IsEven {
	
	/**
	 * Checks whether the given number is even
	 * @param num
	 * @return True if num is even
	 */
	public static boolean isEven(int num) {
		
		return num / 2.0 == (int)(num / 2.0);
	}

	public static void main(String[] args) {
		
		System.out.println("  0 is even = " + isEven(0));
		System.out.println("  1 is even = " + isEven(1));
		System.out.println("100 is even = " + isEven(100));
		System.out.println("255 is even = " + isEven(255));
	}
}
