package arrays;

import java.util.Scanner;

public class Arrays {
	public static void main(String[] args){
		int [] s = new int[5];
		int [] x = {1,2,3,4};
		int [][]t = new int[3][];

		for(int i = 0; i < x.length ; i++){
			System.out.print(x[i]);
		}

		for(int i : x){
			System.out.println("the farm is: " + i);
		}
	

	Scanner scan = new Scanner(System.in);
	System.out.print("Enter the next line");
	int input = scan.nextInt();

  // if the next line
	if(input%2 ==0){
		System.out.print("your number" + input + "even!");
	} else {
		System.out.print("your number" + input + "is odd");
	}
	
      
	}

}