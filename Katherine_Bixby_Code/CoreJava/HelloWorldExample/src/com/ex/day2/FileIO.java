package com.ex.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileIO {

	static String filename = "src/com/ex/day2/log.txt";
	// Read from and right to a text file
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		writeMessage("Hello Genesis!\n"
				+ df.format(dateobj));
	}
	static void writeMessage(String message) {
		try(BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter(filename,true));){
			bw.write(message+"\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static ArrayList<String> readMessage(){
		ArrayList<String> messages = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line=br.readLine())!=null) {
				messages.add(line);
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages;
	}

}
