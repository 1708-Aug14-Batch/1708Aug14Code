package questionFour;

public class Factorial {

	public static int factorial(int n){
		if(n<1){
			//this is the base case, it returns 1
			return 1;
		}
		else{
			//if it is not at the base case, the program recursively calls itself
			//on n-1
			int result = factorial(n-1)*n;
			return result;	
		}
	}


	public static void main(String[] args) {
		//This tests factorial
		int number = factorial(5);
		System.out.println(number);
	}


}
