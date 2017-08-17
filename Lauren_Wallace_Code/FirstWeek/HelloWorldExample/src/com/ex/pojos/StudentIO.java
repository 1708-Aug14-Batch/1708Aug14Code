package com.ex.pojos;

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
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String text = " ";
			
			text = text.concat(s.getFirstName()+":");
			text = text.concat(s.getLastName()+":");
			text = text.concat(s.getEmail()+"\n");
			
			bw.write(text);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentEmail(String file, String tEmail) {
		String oldFile = filename; //original file with original content
		String newFile = file;     //new file to view differences between them
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(oldFile));
			bw = new BufferedWriter(new FileWriter(newFile));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(tEmail)) {         //checks if the line contains the email
					line = line.replace(line, "");  //to delete then replaces it with ""
					
				}
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	
	}
	
	public void updateStudentEmail(String file, String oEmail, String nEmail) {
		String oldFile = filename;
		String newFile = file;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(oldFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(oEmail)) {
					line = line.replace(oEmail, nEmail); //replaces the old email with 
				}										 //the new specified one
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public ArrayList<Student> readStudents() {
		ArrayList<Student> list = new ArrayList<Student>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			Student temp = new Student();
			String line = null;
			while((line = br.readLine()) != null) {
				//.split takes in a regular expression
				String[] states = line.split(":");
				temp.setFirstName(states[0]);
				temp.setLastName(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}