package com.question19;

import java.util.ArrayList;

public class Question19 {
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		ArrayList<Integer> myArray = new ArrayList<Integer>();

		for(int i = 1; i <= 10; i++){
				myArray.add(i);
			}
		int num1 = 0;
		int num2 = 0;
		
		for(int i = 0; i < myArray.size(); i++){
			Integer number = myArray.get(i);
			if(number % 2 == 0){
				num1 += number;
				
			}else{
				num2 += number;
			}
			if(isPrime(number)){
				myArray.remove(i);
				i--;
			}
		}
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(myArray);
	}
}
