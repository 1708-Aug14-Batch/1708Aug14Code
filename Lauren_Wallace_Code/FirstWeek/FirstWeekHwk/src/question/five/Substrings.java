package question.five;

import java.util.LinkedList;
import java.util.Queue;

public class Substrings {

	public static void main(String[] args) {
		
		subString("Good Morning New York!", 6);
		
	}
	
	public static void subString(String str, int index) {
		
		Queue<Character> charQueue = new LinkedList<Character>()
;		
		for (int i = 0; i < index; i++) {
			charQueue.offer(str.charAt(i));
		}
		
		System.out.println(charQueue);
		
	}

}
