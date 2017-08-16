package com.ex.day3;

public class Fibo {
	public static void main(String[] args) {
		//		Scanner scan = new Scanner(System.in);
		//		System.out.println("Enter Fibonacci Number: ");
		//		int i = scan.nextInt();
		//		
		
	}

	public int fib(int i) {
		int fibNum = 0;
		if(i == 1 ){
			System.out.println("FibNum 1 = 0"); //print out if first or higher number
			return 0;
		}
		if(i == 2 ){
			System.out.println("FibNum 2 = 1"); //print out if second or higher number
			return 1;
		}
		if(i > 2 ){
			int prev1 = 0;
			int prev2 = 1;
			//loops through rest of fib numbers
			for(int j = 3; j < i+1; j++){
				//Fib num = previous two fib nums
				fibNum = prev1 + prev2;
				//set previous
				prev1 = prev2;
				prev2 = fibNum;
			}
		}
		System.out.println("FibNum "+i+" = " + fibNum);
		return fibNum;
	}

}
