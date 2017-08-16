package problem3;

import java.util.Stack;

public class Problem3 {
	//Q3. Reverse a string without using a temporary variable.  
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		//System.out.println(reverse);
	}

	public String reverse(String word) {
		
		Stack stack = new Stack();

		String reverse = "";

		//Throw into stack and spit it back out
		
		for(int x = 0; x < word.length(); x++) {
			stack.push(word.charAt(x));
		}
		
		while(!stack.empty()) {
			reverse += stack.pop();
		}
		
		return reverse;
	}
	
}
