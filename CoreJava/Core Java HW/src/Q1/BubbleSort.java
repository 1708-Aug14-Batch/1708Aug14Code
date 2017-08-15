package Q1;

public class BubbleSort {
	
	public static void bubbleSort (int[] list) {
		// Iterate through each element of the array
		for (int j : list) {
			for (int i : list) {
				
				// Switch neighboring elements if they are out of order
				if (list[i] > list[i+1]) {
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int[] list = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		for (int i : list) System.out.print(i + ", ");
		System.out.println();
		
		bubbleSort(list);
		
		for (int i : list) System.out.print(i + ", ");
	}
}
