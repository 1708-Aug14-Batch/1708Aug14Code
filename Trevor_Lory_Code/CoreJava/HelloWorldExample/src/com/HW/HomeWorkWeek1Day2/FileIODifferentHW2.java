package com.HW.HomeWorkWeek1Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileIODifferentHW2 {

	public static void main(String[] args) {
		String file = "src/com/ex/files/HWDay2.txt";
		try {
			writeMessage(file, "This is HW Day 2 File IO testing!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<String> Data = readFile(file);
			for(String line : Data) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Writes bytes to file by converting Strings to chars and ints
	public static void writeMessage(String filename, String message) throws IOException {
		FileOutputStream out = new FileOutputStream(filename, true);
		for(int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			out.write((int)c);
		}
		out.write((int)'\n');
		out.close();
	}
	
	//Reads individual bytes from file and converts them into chars and Strings to be later printed out.
	public static ArrayList<String> readFile(String filename) throws IOException {
		ArrayList<String> filecontents = new ArrayList<String>();
		String temps = "";
		FileInputStream in = new FileInputStream(filename);
		int by = 0;
		while((by = in.read()) != -1) {
			if((char)by == '\n') {
				filecontents.add(temps);
				temps = "";
			}
			else
				temps += (char)by;
		}
		filecontents.add(temps);
		in.close();
		return filecontents;
	}
	
}
