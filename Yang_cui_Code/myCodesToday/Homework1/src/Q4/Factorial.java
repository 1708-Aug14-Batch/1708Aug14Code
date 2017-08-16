package Q4;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
		new Factorial();
	}
	
	public Factorial(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a random number to factorial");
		int num =input.nextInt();
		int fct=0;
		
		for (int i=0; i<=num; i++)
			fct=fct+num*(num-1);
		
		System.out.println(fct);
	}
}
