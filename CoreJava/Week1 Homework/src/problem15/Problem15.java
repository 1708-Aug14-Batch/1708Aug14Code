package problem15;

public class Problem15 {
	//Q15. Write a program that defines an interface having the following methods: 
	//addition, subtraction, multiplication, and division.  
	//Create a class that implements this interface and 
	//provides appropriate functionality to carry out the required operations. 
	//Hard code two operands in a test class having a main method that 
	//calls the implementing class.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operations ops = new Operations();
		
		double x = 100.13;
		double y = 20.23;
		
		System.out.println("Multiplcation " + ops.addition(x, y));
		
		System.out.println("Subtration " + ops.subtraction(x, y));
		
		System.out.println("Multiplcation " + ops.multiplication(x, y));
		
		System.out.println("Division " + ops.division(x, y));

	}

}
