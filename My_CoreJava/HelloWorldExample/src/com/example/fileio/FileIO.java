package com.example.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

public class FileIO {
	
	static final String FILENAME = "src/com/example/fileio/log.txt";
	
	static void writeMessage(String message) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			bw.write(ts.toString() + ": " + message + '\n');
		}		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String readFile() {
		String str = "";
		try (Scanner scan = new Scanner(new FileReader(FILENAME))) {
			while (scan.hasNext()) {
				str += scan.nextLine() + '\n';
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		writeMessage("Hello Nathan!");
		
		System.out.println(readFile());
	}
}
