package com.questionTwo;

public class Main {

	public static void main(String[] args) {
		
		
		//for(int i = 0; i < 25; i++){
			//System.out.println(fibonacci(i));
		//}

	}
	public long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

}
