package com.ex.Q6;

public class FindEven {

	public static void main(String[] args) {
		System.out.println("25 is " + isEven(25));
		System.out.println("8 is " + isEven(8));
		System.out.println("9 is " + isEven(9));
		System.out.println("0 is " + isEven(0));
	}
	
	//is even using char and strings
	static boolean isEven(int i){
		
		//0 is not even
		if(i == 0) return false;
		
		//get string from int value
		String num = String.valueOf(i);
		//get last digit
		char lastNum = num.charAt(num.length()-1);
		//even if last digit is in {2,4,6,8,0}
		switch (lastNum) {
		case '2': return true;
		case '4': return true;
		case '6': return true;
		case '8': return true;
		case '0': return true;
		default:
			return false;
		}
	}
}
