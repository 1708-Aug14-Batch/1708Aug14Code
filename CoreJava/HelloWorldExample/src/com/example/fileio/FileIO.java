package com.example.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	static final String FILENAME = "src/com/example/fileio/log.txt";
	
	static void writeMessage(String message) {
		
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true));
				) {
			bw.write(message + '\n');
		}		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeMessage("Hello Nathan!");
	}
}
