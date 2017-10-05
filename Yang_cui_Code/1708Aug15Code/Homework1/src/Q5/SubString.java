package Q5;

import java.util.Scanner;

public class SubString {
	public static void main(String[] args){
		new SubString();
	}
	
	public SubString(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a random string to reverse");
		String str =input.nextLine();
		System.out.println("Enter a subString index");
		int sub = input.nextInt();
		
		char[] charArray = str.toCharArray();
		char[] subArray = new char[sub];
		
		for(int i=0; i<subArray.length; i++)
			subArray[i]=charArray[i];
		
		String subString =String.valueOf(subArray);
		System.out.println(subString);
	}
}
