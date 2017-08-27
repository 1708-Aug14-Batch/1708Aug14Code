package com.ex.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class StudentIO {
	
	static String fileName = "src/students.txt";
	
	public void writeStudent(Student student) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
			String fileText = "";
			fileText += student.getFirstName() + ":";
			fileText += student.getLastName() + ":";
			fileText += student.getEmail() + "\n";
			bw.write(fileText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> readStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			Student temp = new Student();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] states = line.split(":");
				temp.setFirstName(states[0]);
				temp.setLastName(states[1]);
				temp.setEmail(states[2]);
				students.add(temp);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return students;
	}
	
	public void updateStudent(Student student) {
		this.writeStudent(student);
	}
	
	public void destroyStudent(Student student) {
		ArrayList<Student> allStudents = this.readStudents();
		
	}

	public Student findStudent(String searchCriterion) {
		if (searchCriterion == null) {
			throw new IllegalArgumentException("Search criterion cannot be null");
		}
		ArrayList<Student> allStudents = this.readStudents();
		Student selectedStudent = null;
		for (Student student : allStudents) {
			if (student.getFirstName().equals(searchCriterion)) {
				selectedStudent = student;
				break;
			}
			if (student.getLastName().equals(searchCriterion)) {
				selectedStudent = student;
				break;
			}
			if (student.getEmail().equals(searchCriterion)) {
				selectedStudent = student;
				break;
			}
		}
		return selectedStudent;
	}

}
