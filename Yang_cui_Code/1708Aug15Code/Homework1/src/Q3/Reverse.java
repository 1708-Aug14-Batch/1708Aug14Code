package Q3;

import java.util.Scanner;

public class Reverse {
	
	public static void main(String[] args){
		new Reverse();
	}
	
	public Reverse(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a random string to reverse");
		String str =input.nextLine();
		
		char[] charArray = str.toCharArray();
		char[] charReverse = new char[charArray.length];
		
		for(int i=0; i<charArray.length; i++)
			charReverse[charArray.length-1-i]=charArray[i];
		
		String flip = String.valueOf(charReverse);
		System.out.println(flip);
	}
}
