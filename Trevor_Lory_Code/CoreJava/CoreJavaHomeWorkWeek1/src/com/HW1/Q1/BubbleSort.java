package com.HW1.Q1;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int correct = 0;
		int spot = 0;
		int temp;
		while (correct <= 9) {
			if(arr[spot] > arr[spot + 1]) {
				temp = arr[spot];
				arr[spot] = arr[spot + 1];
				arr[spot + 1] = temp;
				correct = 0;
			}
			else {
				correct++;
			}
			if(spot >= 9 && correct <= 9) {
				spot = 0;
				correct = 0;
			}
			else {
				spot++;
			}
		}
		
		System.out.println("Order Output: ");
		for(int i = 0; i < 11; i++) {
			System.out.print(" " + arr[i] + ",");
		}

	}

}
