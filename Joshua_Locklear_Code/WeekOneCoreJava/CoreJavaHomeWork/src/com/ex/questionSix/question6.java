package com.ex.questionSix;

public class question6 {
	public static void main(String args[]){
		isEven(2);
	}
	public static void isEven(int number){ 
		int num = number/2; 
		if(num*2== number)
		{ 
			System.out.println("Using division: " + number + " is Even number"); 
		}else{ 
			System.out.println("Using division: " + number + " is Odd number"); 
			} 
		}

}

