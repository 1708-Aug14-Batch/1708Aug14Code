package problem20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem20 {
//	Q20. Create a notepad file called Data.txt and enter the following: 
//	Mickey:Mouse:35:Arizona
//	Hulk:Hogan:50:Virginia
//	Roger:Rabbit:22:California
//	Wonder:Woman:18:Montana
//
//	Write a program that would read from the file and print it out to the screen in the following format:
//
//	Name: Mickey Mouse
//	Age: 35 years
//	State: Arizona State


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "src/problem20/Data.txt";
		
		String read;
				
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			while((read=br.readLine())!=null) {
				String temp[] = read.split(":");
				System.out.println("Name: " + temp[0] + " " + temp[1]);
				System.out.println("Age: " + temp[2] + " Years");
				System.out.println("State: " + temp[3] + " State");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
