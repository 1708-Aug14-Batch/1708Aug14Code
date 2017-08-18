package com.question.nine;

import java.util.ArrayList;

public class PrimeNums {

	public static ArrayList<Integer> storeNums(int max){
		ArrayList<Integer> themNums = new ArrayList<Integer>();
		for(int i=0;i<max;i++) {
			themNums.add(i);
		}
		return themNums;
	}
	
	public static ArrayList<Integer> primeNums(ArrayList<Integer> searchList){
		
		ArrayList<Integer> themPrimes = new ArrayList<Integer>();
		for(int i=0;i<searchList.size();i++) {
			if(isPrime(searchList.get(i))) {
				//System.out.println(i);
				themPrimes.add(i);
			}
			
		}
		return themPrimes;
	}
	
	public static void printArray(ArrayList<Integer> toPrint) {
		for(int i=0;i<toPrint.size();i++) {
			System.out.print(toPrint.get(i)+" ");
		}
	}
	
	public static boolean isPrime(int checkNum) {
	    if (checkNum%2==0) return false;
	    for(int i=3;i*i<=checkNum;i+=2) {
	        if(checkNum%i==0)
	            return false;
	    }
	    return true;
	}

	
}
