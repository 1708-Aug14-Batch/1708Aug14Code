package problem5;

public class Problem5 {
	//Q5. Write a substring method that accepts a string str and an integer idx and 
	//returns the substring contained between 0 and idx-1 inclusive. 
	//Do NOT use any of the existing substring methods in the 
	//String, StringBuilder, or StringBuffer APIs.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(substring("Hello",3));
		
	}
	
	public static String substring(String str, int idx) {
		
		String substring = "";
		
		for(int x = 0; x < idx; x++) {
			substring += str.charAt(x);
		}
		
		return substring;
	}

}
