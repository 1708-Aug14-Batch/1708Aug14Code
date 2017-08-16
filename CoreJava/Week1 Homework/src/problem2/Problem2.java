package problem2;

public class Problem2 {
	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//final int x = 24;
		
		//System.out.println(fibonacci(7));
		
	}
	
	public String fibonacci(int x) {
		String sequence ="";

		int fib1 = 0;
		int fib2 = 1;
		int fibTemp = 0;
		
		//Iteratively add the numbers together and print
		
		for(int i = 0; i<x; i++) {
			if(i == 0) {
				sequence += "0,";
				//System.out.print("0,");
			}
			else if(i == 1) {
				sequence += "1,";
				//System.out.print("1,");
			}
			else {
				fibTemp = fib1 + fib2;
				fib1 = fib2;
				fib2 = fibTemp;
				sequence += (Integer.toString(fibTemp)+",");
				//System.out.print(fibTemp+", ");
			}
		}
		System.out.println(sequence);
		return sequence;
	}

}
