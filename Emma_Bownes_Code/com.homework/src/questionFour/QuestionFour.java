package questionFour;

public class QuestionFour {
	
	public static int factorial(int n){
		if(n<1){
			return 1;
		}
		else{
				int result = factorial(n-1)*n;
				return result;	
		}
	}
	

	public static void main(String[] args) {
		int number = factorial(5);
		System.out.println(number);
	}
	

}
