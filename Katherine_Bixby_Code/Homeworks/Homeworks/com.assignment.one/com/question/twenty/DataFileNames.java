package com.question.twenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A program that reads from the file Data.txt and prinst it out to the screen in the following format:
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * 
 * @author Katie
 */

public class DataFileNames {
	
	// the data file
	static String filename="com.assignment.one/com/question/twenty/Data.txt";

	/**
	 * Reading in the value of the people in the text file
	 * @return
	 * 		An array list of each person the text file contains
	 */
	public ArrayList<Person> readPerson(){
		ArrayList<Person> list = new ArrayList<Person>();
		
		try(BufferedReader br =
				new BufferedReader(
						new FileReader(filename));) {
			
			String line = null;
			while((line=br.readLine())!=null) {
				Person temp = new Person();
				String[] states = line.split(":");	// Delineated by ':' 
				temp.setFirstName(states[0]);
				temp.setLastName(states[1]);
				temp.setAge(states[2]);
				temp.setLocation(states[3]);
				list.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
