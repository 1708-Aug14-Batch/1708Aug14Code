package com.ex.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentIO {
	static String filename = "src/com/ex/io/students.txt";

	public void writeStudent(Student s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			String text = "";
			
			text+= (s.getFname() + ":" + s.getLname() + ":" + s.getEmail() + "\n"); 
			bw.write(text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void overwriteStudent(Student s) {
//		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));){
//			String text = "";
//			
//			text+= (s.getFname() + ":" + s.getLname() + ":" + s.getEmail() + "\n"); 
//			bw.write(text);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public int getIndex(String fname, String lname) {
		
		int index = -1;
		
		ArrayList<Student> tempStu = new ArrayList<>();
		
		tempStu = readStudents();
		
		for(int x = 0; x<tempStu.size(); x++) {
			if(tempStu.get(x).getFname().equals(fname) && tempStu.get(x).getLname().equals(lname)) {
				return x;
			}
		}
		
		return index;
	}
	
	public void clearFile() {
		try {
			PrintWriter erase = new PrintWriter(filename);
			erase.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(String fname, String lname) {
		
		int index = getIndex(fname, lname);
		//System.out.println(index);
		
		ArrayList<Student> tempStu = new ArrayList<>();
		
		tempStu = readStudents();
		
		tempStu.remove(index);
		
		clearFile();
		
		for(Student s: tempStu) {
			writeStudent(s);
		}
	}
	
	public void updateStudent(String fname, String lname, String email) {
		int index = getIndex(fname, lname);

		ArrayList<Student> tempStu = new ArrayList<>();
		
		tempStu = readStudents();
		
		tempStu.get(index).setEmail(email);
		
		clearFile();
		for(Student s: tempStu) {
			writeStudent(s);
		}
	}
	
	public ArrayList<Student> readStudents(){
		
		ArrayList<Student> stuArrList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			//br.readLine().split(":");
			
			String line = null;
			while((line = br.readLine())!=null) {
				String[] states = line.split(":");

				Student tempStu = new Student(states[0],states[1],states[2]);
//				tempStu.setFname(states[0]);
//				tempStu.setLname(states[1]);
//				tempStu.setEmail(states[2]);
				
				stuArrList.add(tempStu);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stuArrList;
	}
}
