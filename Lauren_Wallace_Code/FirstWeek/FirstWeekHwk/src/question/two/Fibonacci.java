package question.two;

public class Fibonacci {

	public static void main(String[] args) {
		
		int[] fibonacci = new int[25];
		fibonacci[0] = 0; //n starts as 0
		fibonacci[1] = 1; //n1 is 1
		
		//for the remaining 23 fibonacci numbers they equal the sum
		//of the previous 2 numbers
		for (int start = 2; start < 25; start++) {
			fibonacci[start] = fibonacci[start-2] + fibonacci[start-1];
		}
		//prints out the array fibonacci
		printSeries(fibonacci);
	}
	
	public static void printSeries(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
