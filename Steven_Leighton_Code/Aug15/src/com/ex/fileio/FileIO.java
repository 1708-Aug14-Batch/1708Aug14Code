package com.ex.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileIO {

	static String fileName ="src/com/ex/files/log.txt"; //creates or overrides file with this name 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a message to log:\n");
		String str = scan.nextLine();
		
		writeMessage(new Date().toString() + ": " + str + "\n");
		System.out.println(getMessage().toString());
	}

	static void writeMessage(String message){
		try(
				BufferedWriter bw = 
					new BufferedWriter(
					new FileWriter(fileName, false));
			){ bw.write(message + "\n");
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	static ArrayList<String> getMessage(){
		ArrayList<String> messages = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line=br.readLine()) != null){
				messages.add(line);
				System.out.println(line);
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return messages;
	}
}