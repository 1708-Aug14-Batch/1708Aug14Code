package com.questionSix;

public class question6 {
	public static void main(String args[]){
		isEven(2);
	}
	public static boolean isEven(int number){ 
		int num = number/2; 
		if(num*2== number)
		{ 
			System.out.println("Using division: " + number + " is Even number");
			return true;
		}else{ 
			System.out.println("Using division: " + number + " is Odd number");
			return false;
			} 
		}

}

