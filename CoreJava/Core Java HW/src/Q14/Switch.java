package Q14;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String option = null;
		do {
			System.out.println("Enter a number or 'e' to Exit: ");
			option = scan.nextLine();

			switch(option) {
			case "1":
				System.out.println("Enter a number to sqrt: ");
				String num = scan.nextLine();
				System.out.println(Math.sqrt(Integer.valueOf(num)));
				break;

			case "2":
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date(System.currentTimeMillis());			
				System.out.println(format.format(date));
				break;

			case "3":
				String str = "I am learning Core Java";
				String[] words = str.split(" ");
				for (String word : words) {
					System.out.println(word);
				}
				break;

			default:
			}
		}
		while (!"e".equals(option.toLowerCase()));
	}
}
