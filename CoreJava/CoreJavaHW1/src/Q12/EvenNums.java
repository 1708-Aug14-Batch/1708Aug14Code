package Q12;

public class EvenNums {
	// Write a program to store numbers from 1 to 100 in an array.
	// Print out all the even numbers from the array.
	// Use the enhanced FOR loop for printing out the numbers.

	public static void main(String[] args) {
		int[] int100 = new int[100];
		for (int i = 0; i < 100; i++) {
			int x = i + 1;
			int100[i] = x;
		}
		for (int x : int100) {
			if(x % 2 == 0) {
				System.out.println(x);
			}
		}
	}
}
