package com.WeekOneHW.QuestionTwenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NotepadWriting {

	static String textfile = "src/com/WeekOneHW/files/textfile.txt"; //Bringing in the textfile
	public static void main(String[] args) {
		fileReader(); //Calling the fileReaer method

	}
	static void fileReader() {
		/*
		 * Creating an BufferedReader/FileReader. Also establishing a String line named null.
		 * Then using a while statement I stepped through each line and outputted the information using the ":" and "\n" as a splitter.
		 */
		
		try(BufferedReader rw = new BufferedReader(
				new FileReader(textfile))){
			
			String line = null;
			while((line = rw.readLine())!=null) {
				String[] states = line.split(":");
				System.out.print("Name: " + states[0] + " " + states[1] + "\n");
				System.out.print("Age: " + states[2] + " years\n");
				System.out.print("State: " + states[3] + " state\n\n");
				}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		};
	}

}
