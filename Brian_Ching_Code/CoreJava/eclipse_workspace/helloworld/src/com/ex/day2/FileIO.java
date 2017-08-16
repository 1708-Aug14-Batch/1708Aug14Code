package com.ex.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileIO {

	static String filename = "src/com/ex/files/log.txt";
	
	public static void main(String[] args) {
		
		writeMessage("Hello Genesis!");
		
	}
	
	static void writeMessage(String message) {
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write(time.format(new Date()) + " " + message + " " + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<String> readMessage() {
		
		ArrayList<String> messages = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			while ((line=br.readLine()) != null) {
				messages.add(line);
				System.out.println(line);
			}
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
