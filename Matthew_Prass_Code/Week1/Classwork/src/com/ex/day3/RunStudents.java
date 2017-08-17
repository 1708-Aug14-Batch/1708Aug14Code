package com.ex.day3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.x.pogos.Student;

public class RunStudents {

	
	static StudentIO sio;
	public static void main(String[] args) {
		
		//you need to run the first two with the delete command commented out first for the full effect
		//the int argument on deleteStudent is referring to to the index of the ArrayList in which it is accessed 
		
		//addStudent();
		//getStudents();
		deleteStudent(0);
	
	}
	
	static void addStudent()
	{
		sio = new StudentIO();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter your first name: ");
		String fn = s.nextLine();
		
		System.out.println("Please enter your last name: ");
		String ln = s.nextLine();
		
		System.out.println("Please enter your email: ");
		String em = s.nextLine();
		
		Student user = new Student(fn,ln,em);
		
		sio.writeStudent(user);
		
		s.close();
		
	}
	
	static void getStudents()
	{
		sio = new StudentIO();
		ArrayList<Student> students = sio.readStudent();
		
		for(Student s: students)
		{
			System.out.println(s.toString());
		}
	}
	
	static void deleteStudent(int i)
	{
		sio = new StudentIO();
		ArrayList<Student> students = sio.readStudent();
		students.remove(i);
		updateStudents(students);
		
	}
	
	static void updateStudents(ArrayList<Student> a)
	{
		sio = new StudentIO();
		ArrayList<Student> newList = new ArrayList<Student>();
		newList = a;
		for(Student s: newList)
		{
			something(s);
		}
	}
	
	static void something(Student s)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(StudentIO.filename,false)))
		{
			String text = "";
			
			text = text.concat(s.toString());
			text = text.concat("\n");
			
			bw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
