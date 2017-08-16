package question.one;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		printArray(array);
		bubbleSortArray(array);
		printArray(array);
	
	}
	
	public static void swapLeftGreater(int[] array, int i, int k, int v1, int v2) {
		int temp = v2;
		array[k] = v1;
		array[i] = temp;
	}
	
	public static void bubbleSortArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			for (int k = 1; k < array.length - 1; k++) {
				if(array[i] > array[k]) {
					//swapLeftGreater(array, i, k, array[i], array[k]);
					int temp = array[k];
					array[k] = array[i];
					array[i] = temp;
				}
			}
		}
		System.out.println();
	}
	
	public static void printArray(int array[]) { //works fine
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
