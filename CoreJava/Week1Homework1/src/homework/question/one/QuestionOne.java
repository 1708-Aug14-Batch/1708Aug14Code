package homework.question.one;

public class QuestionOne {

	public static void main(String[] args) {
		System.out.println("Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4");

		int array[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		System.out.println("Prior to being sorted");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("\nAfter being sorted");
		int sortedArray[] = bubbleSort(array);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}

	}

	public static int[] bubbleSort(int[] array) {
		int sortedArray[] = new int[array.length];

		int tempVar = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					tempVar = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tempVar;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			sortedArray[i] = array[i];
		}

		return sortedArray;

	}

}
