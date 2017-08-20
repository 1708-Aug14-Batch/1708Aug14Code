package com.questionEight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {
	private static ArrayList<String> array1 = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		myList.addAll(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john","refer", "billy", "did"));
		
//		try(BufferedWriter out = new BufferedWriter(new FileWriter("src/com/ex/Files/palindromes.txt"))){
//			Iterator<String> it = myList.iterator();
//			
//			while( it.hasNext() )
//				out.write( "\""+ it.next() + "\", " );
//			
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		System.out.println(myList);
		System.out.println(palindromes(myList));
		
	}
	private static ArrayList<String> palindromes( ArrayList<String> list){
		int compaire;
		int count;
		for(String string: list){
			if(string.length()/2==0){
				compaire = string.length()/2;
				count = 0;
				
				for(int i =0; i< compaire; i++){
					if(string.charAt(i)== string.charAt(string.length()-i-1)){
						count++;
					}
					if(count == compaire){
						array1.add(string);
					}
				}
			}else{
				compaire = (string.length()-1)/2;
				count = 0;
				
				for(int x = 0; x < compaire; x++){
					if(string.charAt(x)== string.charAt(string.length()-x-1)){
						count++;
					}
					if(count == compaire){
						array1.add(string);
					
				}
			}
		}
		
	}
		return array1;
	}
}
