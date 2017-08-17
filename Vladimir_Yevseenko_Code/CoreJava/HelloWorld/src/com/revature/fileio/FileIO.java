package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileIO {
	public static void main(String[] args) {
		String file = "src\\com\\revature\\files\\log.txt";
		Scanner s = new Scanner(System.in);
		/*while(s.hasNext()) {
			writeMsg(file, s.next());
		} */
		s.close();
		ArrayList<String> lines;
		lines = readFile(file);
		for (String line: lines)
			System.out.println(line);
		
	}
	
	public static void writeMsg(String file, String msg) {
		try (BufferedWriter w = new BufferedWriter(new FileWriter(file, true))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			w.write(sdf.format(new Date()) + ": " + msg + "\n");
		} catch (IOException e) {
			System.out.println("Error opening " + file);
		}
	}
	
	public static ArrayList<String> readFile(String file) {
		try (BufferedReader r = new BufferedReader(new FileReader(file))) {
			ArrayList<String> lines = new ArrayList<>();
			String line;
			while ((line = r.readLine()) != null)
				lines.add(line);
			return lines;
		} catch (IOException e) {
			System.out.println("Error opening " + file);
		}
		return null;
	}
}
