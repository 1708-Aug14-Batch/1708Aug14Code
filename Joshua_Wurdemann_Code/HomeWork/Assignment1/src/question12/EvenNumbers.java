package question12;
/**
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 * @author joshw
 *
 */
public class EvenNumbers {

	public static void addToList(int in[]){
		for(int i = 0; i < 100; i++){
			in[i] = i+ 1;
		}
	}


	public static boolean isEven(int n){

		if(n % 2 == 0){
			return true;
		}
		return false;
	}

	public static void printList(int numbers[]){
		for(int s: numbers){
			int number = numbers[s];
			if(isEven(number)){
				System.out.println(number);
			}
		}	
	}

	/**Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 100
	at question12.EvenNumbers.printList(EvenNumbers.java:27)
	at question12.EvenNumbers.main(EvenNumbers.java:37)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[100];
		addToList(numbers);
		printList(numbers);
		//		
		//		for(int s: numbers){
		//			int number = numbers[s];
		//			if(isEven(number)){
		//				System.out.println(number);
		//			}
		//		}

	}

}
