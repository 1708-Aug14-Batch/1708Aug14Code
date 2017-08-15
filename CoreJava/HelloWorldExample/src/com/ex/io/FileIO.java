package com.ex.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileIO {
	static String filename = "src/com/ex/io/log.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Message");
		
		String input = scan.nextLine();
		
		writeMessage(input);
	}
	
	static void writeMessage(String message) {
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));)
				{
			
				Date date = new Date();
				
				SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a  ");
				
				String timeStamp = sdf.format(date);
						
				bw.write(timeStamp + message +"\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
