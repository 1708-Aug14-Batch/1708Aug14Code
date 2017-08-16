package question.three;

import java.util.Scanner;
import java.util.Stack; 

/*
 * Stack was used due to it being LIFO
 * LIFO - Last In First Out
 * meaning the last char put into the stack would be popped off first
 */

public class ReverseString {
	
	static char ch;

	public static void main(String[] args) {
		
		//the use of Scanner makes the code reusable for any word
		System.out.println("Enter a sentence: ");
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		int size = in.length();
		Stack stack = new Stack<String>();
		
		for(int i = 0; i < size; i++) {
			char ch = in.charAt(i);
			stack.push(ch);
		}
		//makes sure to empty the stack
		while (!stack.isEmpty()) {
			ch = (char) stack.pop();
			System.out.print(ch);
		}
		
	}
}
