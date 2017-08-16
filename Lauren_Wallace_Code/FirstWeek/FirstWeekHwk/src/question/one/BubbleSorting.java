package question.one;

public class BubbleSorting {

	public static void main(String[] args) {
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		printArray(array);
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		printArray(array);

	}
	
	public static void printArray(int array[]) { //works fine
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
