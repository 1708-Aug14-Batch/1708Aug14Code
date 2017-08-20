package com.question18;
import java.util.Scanner;

import com.question18.AbstractQuestion18;
public class Concrete extends AbstractQuestion18 {
		private static String words;
		private static int Numbers;
				
			@Override
			
			
			public boolean hasUpperCase() {
				// TODO Auto-generated method stub
				for(int i =0; i < words.length(); i++ ){
					if(Character.isUpperCase(words.charAt(i)));
					return true;
				}
				return false;
			}
			@Override
			public void toUpperCase() {
				// TODO Auto-generated method stub
				words = words.toUpperCase();
			}
			@Override
			public int addTen() {
				// TODO Auto-generated method stub
				return Numbers +10;
			}
	
		
	public static void main(String[] args) {
		Concrete question = new Concrete();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your String");
		String userInput = input.nextLine();
		System.out.println("Enter your String");
		String userChar = input.nextLine();
		System.out.println("Enter your String");
		int userInt = input.nextInt();
		
		System.out.println(question.hasUpperCase()+userInput);
		
	}
	
	
}
