package Q1;

public class BubbleSort {

	public static void main(String[] args) {
        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        System.out.println("Unsorted array");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
	}
	
	// method to bubble sort given array
    static void bubbleSort(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < (arr.length - i) - 1; j++)
                if (arr[j] > arr[j + 1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
    
    // method to print array
    static void printArray(int arr[])
    {
        for (int i = 0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
}
