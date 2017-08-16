package problem3;

import java.util.Stack;

public class Problem3 {
	//Q3. Reverse a string without using a temporary variable.  
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String reverse = "";
		
		Stack stack = new Stack();
		
		//Throw into stack and spit it back out
		
		for(int x = 0; x < alphabet.length(); x++) {
			stack.push(alphabet.charAt(x));
		}
		
		while(!stack.empty()) {
			reverse += stack.pop();
		}
		
		System.out.println(reverse);
	}

}
