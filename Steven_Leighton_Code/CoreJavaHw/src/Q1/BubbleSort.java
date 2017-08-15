package Q1;

public class BubbleSort {

	public static void main(String[] args) {
		
		//given array
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		//sort array from least to greatest using bubblesort
		array = bubbleSort(array);
		
		//print out result
		for(int i : array){
			System.out.print(i + " ");
		}

	}

	public static int[] bubbleSort(int[] arr){
		
		//do loop n times for worst case
		for(int i = 0; i < arr.length - 1; i++){
			
			//use swapped to check if any swaps occured, to escape process early
			boolean swapped = false;
			
			//go through array checking for swaps
			for(int j = 0; j < arr.length - 1; j++){
				//swap if right is less than left
				if(arr[j + 1] < arr[j] ){
					swapped = true;
					arr = swap(arr, j);
				}
			}
			
			//if there were no swaps, end process 
			if (!swapped) break;
		}
		
		//return sorted array
		return arr;
	}
	
	
	public static int[] swap(int[] arr, int i){

		//swap using temp variable
		int x = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = x;
		
		return arr;
	}
	
	
}
