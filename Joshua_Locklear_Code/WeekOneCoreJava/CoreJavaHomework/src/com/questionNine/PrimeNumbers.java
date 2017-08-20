package com.questionNine;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> primeList = new ArrayList<Integer>();
		ArrayList <Integer> primeList2 = new ArrayList<Integer>();
		for(int x = 1; x <= 100; x++){
			primeList.add(x);
			if(isPrime(x)){
				System.out.println(x);
			}
		}
		
//		for(int y = 1; y <= 100; y++){
//			if(isPrime())
//		}
		
	}
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
