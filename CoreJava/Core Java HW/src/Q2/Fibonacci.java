package Q2;

public class Fibonacci {
	
	/**
	 * Prints the first n numbers of the Fibonacci sequence
	 * @param n Amount of Fibonacci sequence to print
	 */
	public static void fibFirstN(int n) {
		doFib(0, 1, n);
	}

	private static void doFib(int start, int next, int n) {
		// Return after n Fibonacci numbers
		if (n == 0) return;
		
		// Print the current Fibonacci number
		System.out.print(start + ", ");

		// Recursively continue through the Fibonacci sequence
		// by adding the previous number to the current number
		doFib(next, start + next, n-1);
	}
	
	public static void main(String[] args) {
		
		fibFirstN(25);		
	}
}
