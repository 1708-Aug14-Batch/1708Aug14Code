package Q6;

import java.util.Scanner;

public class OddEven {
	public static void main(String[] args){
		new OddEven();
	}
	
	public OddEven(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a random number test for odd or even");
		int num = input.nextInt();
		boolean even=false;
		
		for(int i=0; i<num; i++)
			if(2*i==num){
				even=true;
				break;
			}
		
		if(even)
			System.out.println("the number is even");
		else
			System.out.println("the number is odd");
	}
}
