package homework.question.six;

import java.util.*;

public class QuestionSix {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Q6. Write a program to determine if an integer is even without using the modulus operator (%)");

		System.out.println("Type in any number to see if it's even");
		int input = scan.nextInt();
		if (isEven(input) != true) {
			System.out.println(input + " is not an even integer");
		} else {
			System.out.println(input + " is an even integer");
		}
	}

	public static boolean isEven(int input) {
		try {
			double inputDouble = input;
			double halfDouble = inputDouble / 2;
			double halfInt = input / 2;
			if (halfInt != halfDouble) {
				return false;
			}
			return true;
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return false;
	}
}
