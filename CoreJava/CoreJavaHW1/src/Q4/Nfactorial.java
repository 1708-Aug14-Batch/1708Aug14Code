package Q4;

public class Nfactorial {

	public static void main(String[] args) {
	// Factorial of n is the product of all positive descending integers
		int fact = 1;  
		int number = 5;    
		for(int i = 1; i <= number; i++) {    
			fact *= i;    
		}    
		System.out.println("Factorial of " + number + " is: " + fact);    
	}  
}
