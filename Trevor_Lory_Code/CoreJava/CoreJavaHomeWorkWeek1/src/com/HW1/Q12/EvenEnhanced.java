package com.HW1.Q12;

public class EvenEnhanced {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i = 1; i <= 100; i++) {
			arr[i - 1] = i;
		}
		for(int num : arr) {
			if(num%2 == 0) {
				System.out.println(num);
			}
		}
	}
	
}
