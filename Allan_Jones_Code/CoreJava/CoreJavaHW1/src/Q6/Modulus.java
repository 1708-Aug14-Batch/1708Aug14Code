package Q6;

public class Modulus {
	//Write a program to determine if an integer is even without using the modulus operator (%)
	
	public static void main (String [] args){
	    int a = 50;
	    int b = 3;

	    int c = a%b;
	    int d = a - (a/b)*b;

	    System.out.println("Answer using modulo operator: " + c);
	    System.out.println("Answer without using modulo operator: " + d);
	}
}
