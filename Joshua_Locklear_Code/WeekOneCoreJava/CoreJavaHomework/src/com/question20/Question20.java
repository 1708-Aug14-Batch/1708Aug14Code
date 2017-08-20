package com.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Question20 {
	public static void main(String[] args) {
		
		String myLine;
		StringTokenizer myString = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/ex/Files/List.txt"))){
			while((myLine = br.readLine()) != null){
				myString = new StringTokenizer(myLine,":");
				
				String[] myData = {"Name","Age","State"};
				
				int counter = 0;
				System.out.println( myData[counter] + ": " + myString.nextToken() + " " + myString.nextToken() );
				while(myString.hasMoreTokens()){
					counter++;
					System.out.println(myData[counter]+":"+myString.nextToken());
				}
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
