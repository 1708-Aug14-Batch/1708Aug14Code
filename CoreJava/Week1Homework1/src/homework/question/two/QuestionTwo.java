package homework.question.two;

public class QuestionTwo {

	public static void main(String[] args) {
		System.out.println("Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. ");

		fibonacci(25);

	}

	public static void fibonacci(int length) {
		int[] fibonacci = new int[length];

		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}

		for (int i = 0; i < fibonacci.length; i++) {
			System.out.print(fibonacci[i] + " ");
		}

	}

}
