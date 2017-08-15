package com.ex.CoreJavaHomework;

public class BubbleSort {
	static void bubbleSort(int[] myArray){
		int x = myArray.length;
		int tempVar = 0;
		
		for(int i=0; i<x; i++){
			for(int j = 1; j< (x-i); j++){
				if(myArray[j-1]>myArray[j]){
					tempVar = myArray[j-1];
					myArray[j-1] = myArray[j];
					myArray[j]=tempVar;
				}
			}
		}
		return;
	}
}
