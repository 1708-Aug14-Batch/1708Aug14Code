package homework.question.four;

public class QuestionFour {
	public static void main(String[] args) {
		System.out.println("Q4. Write a program to compute N factorial.");
		System.out.println(factorial(3));
	}

	public static int factorial(int input) {
		if (input != 0) {
			return input * (factorial(input - 1));
		} else {
			return 1;
		}
	}
}
