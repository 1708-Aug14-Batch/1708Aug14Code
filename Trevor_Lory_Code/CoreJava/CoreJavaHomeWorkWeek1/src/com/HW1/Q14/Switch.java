package com.HW1.Q14;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while(running) {
			System.out.println("What do you want to do? \nsqrt / date / string split (1 / 2 / 3): ");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("Please enter a number: ");
				Integer in = scan.nextInt();
				System.out.println(Math.sqrt(in.intValue()));
				running = false;
				break;
			case "2":
				System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
				running = false;
				break;
			case "3":
				String[] arr;
				arr = "I am learning Core Java".split(" ");
				for(String s : arr) {
					System.out.println(s);
				}
				running = false;
				break;
			default:
				System.out.println("Invalide Input PLease try again.");
				break;
			}
		}
		scan.close();
	}
	
}
