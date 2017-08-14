package question1;

public class Question1 {
	
	static int numArray[] = new int[11];

	public static void main(String[] args) {

		numArray[0] = 1;
		numArray[1] = 0;
		numArray[2] = 5;
		numArray[3] = 6;
		numArray[4] = 3;
		numArray[5] = 2;
		numArray[6] = 3;
		numArray[7] = 7;
		numArray[8] = 9;
		numArray[9] = 8;
		numArray[10] = 4;

		// prior to being sorted
		printArray(numArray);
		bubbleSort(numArray);

		// after being sorted
		printArray(numArray);
	}

	private static void bubbleSort(int[] numArray) {
		// TODO create a working bubbleSort

	}

	private static void printArray(int[] numArray) {
		// TODO create a working print for int arrays
	}
}
