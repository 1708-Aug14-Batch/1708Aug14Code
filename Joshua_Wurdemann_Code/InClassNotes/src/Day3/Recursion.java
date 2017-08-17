package Day3;
/**
 * 
 * @author Joshua Wurdemann
 * @version 8/16/2017
 */
public class Recursion {

	public static void main(String[] args) {
	//	System.out.println(factorial(4));
	}
	/** Mulitple numbers continually until reach base case*/
	public int factorial(int n){
		if(n == 1)
			return 1;
		
		return n * factorial(n-1);
		
			
	}
	
	
		
	}

