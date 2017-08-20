package com.hw.problem14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		int option = 1;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter one of the following numbers (1, 2, 3): ");
		option = scan.nextInt();
		
		
		switch (option) {
		case 1: 
			double num = 0;
			System.out.print("Enter a number to sqrt: ");
			num = scan.nextDouble();
			System.out.println("Square Root of" + num + " = " + Math.sqrt(num));
			break;
		case 2: 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3: 
			System.out.println("'I am learning core java' split: ");
			for (String str: "I am learning core java".split(" "))
				System.out.println(str);
		}
		
		
	}
	
	

}
