package problem1;

import java.util.Arrays;

public class Problem1 {
	//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intArr[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println(Arrays.toString(intArr));
		
		// Loop through the array
		for(int i = 0; i < intArr.length; i++)
			// Loop for individual comparison
			for(int j = 0; j < intArr.length; j++) {
				if(intArr[i] < intArr[j]) {
					int temp;
					temp = intArr[j];
					intArr[j] = intArr[i];
					intArr[i] = temp;
				}
			}
		
		System.out.println(Arrays.toString(intArr));
	}

}
