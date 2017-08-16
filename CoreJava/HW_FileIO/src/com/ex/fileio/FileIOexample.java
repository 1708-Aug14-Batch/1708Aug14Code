package com.ex.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileIOexample {
	static String filename = "src/com/ex/files/log.txt";

	public static void main(String[] args) {
		writeMessage("Hello World");
		readMessage();
	}
	
	static void writeMessage(String message) {
		try (PrintStream out = new PrintStream(new FileOutputStream(filename));) {
			out.print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readMessage() {
		try (FileInputStream in = new FileInputStream(filename);) {
			int content;
			while ((content = in.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
