package com.ex.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	static String fileName = "src/test.txt";
	
	/**
	 * When I tried this method the first time, it outputed 
	 * the file contents in brackets.
	 * After adding a new line to the file, I see 
	 * that the brackets are added because the println statement is 
	 * outputting the contents of an ArrayList.
	 */
	public static ArrayList<String> readFileViaScanner() {
		ArrayList<String> fileInput = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
			while(scanner.hasNext()) {
				fileInput.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();
		return fileInput;
	}
	
	/**
	 * This is an extremely convenient way to read the contents 
	 * of a text file.
	 */
	public static ArrayList<String> readFileViaFilesClass() {
		ArrayList<String> fileInput = new ArrayList<String>();
		try {
			for(String line : Files.readAllLines(Paths.get(fileName))) {
				fileInput.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileInput;
	}
	
	public static void main(String[] args) {
		System.out.println(readFileViaScanner());
		System.out.println(readFileViaFilesClass());
	}

}
