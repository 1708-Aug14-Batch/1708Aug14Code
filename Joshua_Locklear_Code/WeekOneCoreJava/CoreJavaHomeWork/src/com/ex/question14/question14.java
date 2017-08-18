package com.ex.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class question14 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Pick a case 1-3: ");
		int input1 = in.nextInt();
		
		
		switch(input1){
			case 1:{
					System.out.println("Please enter the number you would like to square root: ");
					double number = in.nextDouble();
					double sq = Math.sqrt(number);
					}
				break;
			case 2:{
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					System.out.println("Todays date is: "+ dateFormat.format(date) );
				   }		
				break;
			case 3:	{
					String[] split= split("I am learning Core Java");
					for(int i=0; i<split.length; i++)
					System.out.println(split[i]);
					}
				break;
		}

	}
	
	public static String[] split(String str){
		return str.split(" ");
	
}
}
