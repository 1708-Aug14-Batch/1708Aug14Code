package com.questionFour;

public class nFactorial {
	static int nfactorial(int x){
		if(x == 0){
			return 1;
		}
		else
			return(x*nfactorial(x-1));
	}
	
	public static void main(String args[]){
		//int i;
		int factorial = 1;
		int num = 4;
		
		factorial = nfactorial(num);
		System.out.println("Factorial of " + num + " is" + factorial);
	}
	
}
