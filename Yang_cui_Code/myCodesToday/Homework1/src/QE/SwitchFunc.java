package QE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SwitchFunc {
	public static void main(String[] args){
		new SwitchFunc();
	}
	
	public SwitchFunc(){
		Scanner input = new Scanner(System.in);
		System.out.println("Case 1: Find the square root of a number using the Math class method. ");
		System.out.println("Case 2: Display today’s date. ");
		System.out.println("Case 3: Split the following string and store it in a sting array. I am learning Core Java");
		int user = input.nextInt();
		
		switch(user){
		case 1: {
			System.out.println("please enter a number to find SQRT");
			int num = input.nextInt();
			double sqrt =findSQRT(num);
			System.out.println("the SQRT of "+num+" is "+sqrt);
		}break;
		case 2: {
			System.out.println("Today's date is ");
			displayDate();
		}break;
		case 3: {
			System.out.println("I am learning Core Java");
			String[] split= splitString("I am learning Core Java");
			for(int i=0; i<split.length; i++)
				System.out.println(split[i]);
		}break;
		default: System.out.println("wrong choice"); break;
		}
	}
	
	public double findSQRT(double number){
		return Math.sqrt(number);
	}
	
	public void displayDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}
	
	public String[] splitString(String str){
		return str.split(" ");
	}
}
