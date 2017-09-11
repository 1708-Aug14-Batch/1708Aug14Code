import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter a number");
		int input = scan.nextInt();
		
		int x[] = {1,2,3,4,5};
		
		for(int i:x) {
			System.out.println("A: " + i);
			if(x[i]==3) {
				continue;
			}
			System.out.println("B: " + i);
			if(x[i]==4) {
				break;
			}
		}
		
		if(input%2 == 0) {
			System.out.println("your number " + input + " is even!");
		} else if(input%5 == 0) {
			System.out.println("divisible by 5");
		} else {
			System.out.println("your number " + input + " is odd!");
		}
		
		switch(input) {
		case(10): System.out.println("its 10");
		break;
		case(100): System.out.println("100");
		break;
		default:
			System.out.println("default");
		}

	}

}
