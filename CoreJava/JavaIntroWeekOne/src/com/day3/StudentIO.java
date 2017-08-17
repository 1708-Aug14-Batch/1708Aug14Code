package com.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentIO {
	String filename = "src/com/day3/students.txt";
	
	public void writeStudents(Student s) {
		try(BufferedWriter bw =
				new BufferedWriter(
						new FileWriter(filename, true));){
			String text = "";
			
			text=text.concat(s.getFirstname()+":");
			text=text.concat(s.getLastname()+":");
			text=text.concat(s.getEmail()+"\n");
			
			bw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> readStudents(){
		ArrayList<Student> list = new ArrayList<Student>();
		
		try(BufferedReader br =
				new BufferedReader(
						new FileReader(filename));){
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] states = line.split(":");
				Student temp = new Student();
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void updateStudents(ArrayList<Student> list){
		
		try(BufferedWriter bw =
				new BufferedWriter(
						new FileWriter(filename, false));){
			String text = "";
			bw.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		}
			for(Student s:list) {
			writeStudents(s);
			}

	}
	
	public ArrayList<Student> deleteStudent(Student student) {
		ArrayList<Student> list = new ArrayList<>();
		list = readStudents();
		Student s;
		for(int i=0;i<list.size();i++) {
			s = list.get(i);
			if(s.getEmail().equals(student.getEmail())) {
				list.remove(s);
			}
		}
		return list;
		
	}
	

}
