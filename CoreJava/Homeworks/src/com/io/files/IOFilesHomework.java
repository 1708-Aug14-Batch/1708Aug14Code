package com.io.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IOFilesHomework {
	
	private static Scanner scan;

	public static void main(String[] args) {
		String filename = "src/com/io/files/text.txt";
		try {
			scan = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		 while (scan.hasNextLine()) {
	            String line = scan.nextLine();
	            System.out.println(line);
	        }
		 
	        scan.close();
	}

}
