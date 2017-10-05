package Q11;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args){
		new Interest();
	}
	
	public Interest(){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter principle");
		int principle= input.nextInt();
		System.out.println("please enter rate");
		int rate= input.nextInt();
		System.out.println("please enter time");
		int time= input.nextInt();
		
		int interest= principle*rate*time;
		System.out.println("your interest is "+interest);
	}
}
