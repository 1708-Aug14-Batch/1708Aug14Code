package com.ex.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentIO {
	static String filename = "src/com/ex/files/students.txt";

	public void writeStudent(Student s) {
		
		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(filename,true))){
			String text = " ";
			
			text = text.concat(s.getFirstname()+":"); // the : is used for breaking the file for a later array
			text = text.concat(s.getLastname()+":");
			text = text.concat(s.getEmail()+"\n"); //Line break used here to stop the Reader from reading
			
			bw.write(text);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Student> readStudents(){
		ArrayList<Student> list = new ArrayList<Student>();
		
		try(BufferedReader rw = new BufferedReader(
				new FileReader(filename))){
			
			
			String line = null; //This variable is used for reading through the file
			while((line = rw.readLine())!= null) { //While the line variable can read from the reader.
				Student temp = new Student(); //Temp student used to fill in the attributes
				String[] states = line.split(":"); //String array use to store each different attribute. Using .split(":") is where its split into each elements
				temp.setFirstname(states[0]); //Sets the attributes to each array element
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateStudents(ArrayList<Student> s){

		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(filename,false))){
			String text = " ";
			
			for(Student i: s) {
				text = text.concat(i.getFirstname() + ":");
				text = text.concat(i.getLastname() + ":");
				text = text.concat(i.getEmail() + "\n");
			}
			
			bw.write(text);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		


	
	}	
}
