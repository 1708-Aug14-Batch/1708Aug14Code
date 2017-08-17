package question.six;

public class EvenOrOddWithoutMod {

	public static void main(String[] args) {
		//calls the method to check the number given
		checkNum(2);
		checkNum(5);
		checkNum(6);
	}
	
	public static void checkNum (int num) {
		
		//Since integers are stored as 2's complement if the method uses the bitwise &
		//operator on even integers the result should be = to 0
		if ((num & 1) == 0) {
			System.out.println("Your number" + num + " is even!");
		}
		else {
			System.out.println("Your number" + num + " is odd!");
		}
	}
}
