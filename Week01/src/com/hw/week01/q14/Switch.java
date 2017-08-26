package com.hw.week01.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Switch {
	
	public static void demonstrateSwitch(int option) {
		switch(option) {
			case 1:
				System.out.println("Square root of 100 is " + Math.sqrt(100));
				break;
			case 2:
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				System.out.println("Today's date is " + format.format(date));
				break;
			case 3:
				String stringToSplit = "I am learning Core Java";
				System.out.println(stringToSplit);
				String[] splitString = stringToSplit.split(" ");
				for(String token : splitString) {
					System.out.println(token);
				}
				break;
		}
	}

}
