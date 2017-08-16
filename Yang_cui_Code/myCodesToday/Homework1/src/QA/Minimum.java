package QA;

import java.util.Scanner;

public class Minimum {
	public static void main(String[] args){
		new Minimum();
	}
	
	public Minimum(){
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number");
		int a = input.nextInt();
		System.out.println("enter another number");
		int b = input.nextInt();
		int min = (a < b) ? a : b;
		System.out.println("the small number is "+min);
	}
}
