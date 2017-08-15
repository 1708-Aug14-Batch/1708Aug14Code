package com.example.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

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
	
	public static void main(String[] args) {
		writeMessage("Hello Nathan!");
	}
}
