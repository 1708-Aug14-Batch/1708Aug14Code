package questionFourtn;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class DoThings {
	static Scanner scan;
	
	public static double findSqr(double n) {
		//math takes square root of number
		double m = Math.sqrt(n);
		return m;
	}
	public static String giveDate() {
		String date;
		//creates date format object
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy"); 
		//gets instance of calendar, to find current time
		Calendar now = Calendar.getInstance();
		//enter time into the Date constructer to get the dat
		Date date1 = new Date(now.getTimeInMillis());
		//format date using the date formatter specified above
		date = dateFormat.format(date1);
		//return date
		return date;
	}
	public static String[] splitString(String string) {
		//initializes array
		String[] array = new String[string.length()];
		for (int i=0; i< string.length(); i++) {
			//populates array
			array[i]= string.substring(i, i+1);
		}
		return array;
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Please enter any integer");
		int input = scan.nextInt();
		//this makes any entered integer break into three cases
		switch (input%3) {
		case 1:
			double squareRoot = findSqr(input);
			System.out.println(squareRoot);
			break;
		case 2:
			System.out.println("Today is "+giveDate());
			break;
		case 0:
			for(String s: splitString("I am learning Core Java")) {
				System.out.print( s+" ");
			}
			break;
		default:
			break;
		}
	}

}
