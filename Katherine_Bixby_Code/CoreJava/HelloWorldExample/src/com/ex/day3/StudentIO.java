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
	
	static String filename="src/com/ex/day3/students.txt";
	
	public void writeStudent(Student s) {
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename,true))) {
			String text = "";
			
			text = text.concat(s.getFirstName()+":");
			text = text.concat(s.getLastName()+":");
			text = text.concat(s.getEmail()+"\n");
			
			bw.write(text);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Student> readStudents(){
		ArrayList<Student> list = new ArrayList<Student>();
		
		try(BufferedReader br =
				new BufferedReader(
						new FileReader(filename));) {
			
			
			String line = null;
			while((line=br.readLine())!=null) {
				Student temp = new Student();
				String[] states = line.split(":");
				temp.setFirstName(states[0]);
				temp.setLastName(states[1]);
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
	
	public ArrayList<Student> updateStudent(ArrayList<Student> theStudents){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the old email of the student you'd like to update: ");
		String email = scan.nextLine().trim();
		Student updatedStudent = new Student();
		ArrayList<Student> updatedStudentList = new ArrayList<Student>();
		String tempEmail;
		for (int i=0;i<theStudents.size();i++) {
			System.out.println(email);
			System.out.println(theStudents.get(i).getEmail());
			tempEmail = theStudents.get(i).getEmail();
			if(email.equals(tempEmail)) {
				System.out.println("Enter new first name: ");
				String newFn = scan.nextLine().trim();
				System.out.println("Enter new last name: ");
				String newLn = scan.nextLine().trim();
				System.out.println("Enter new email: ");
				String newEmail = scan.nextLine().trim();
				updatedStudent.setFirstName(newFn);
				updatedStudent.setLastName(newLn);
				updatedStudent.setEmail(newEmail);
				updatedStudentList.add(updatedStudent);
			}
			else {
				updatedStudentList.add(theStudents.get(i));
			}
		}
		
		scan.close();
		return updatedStudentList;
	}
	
	
	public ArrayList<Student> deleteStudent(ArrayList<Student> theStudents){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the email of the student you'd like to delete: ");
		String deleteEmail = scan.nextLine().trim();
		ArrayList<Student> updatedStudentList = new ArrayList<Student>();
		
		for(int i=0;i<theStudents.size();i++) {
			if(deleteEmail==(theStudents.get(i)).getEmail()) {
				System.out.println("Deleting: "+theStudents.get(i).getFirstName()+" "+theStudents.get(i).getLastName()+".");
			}
			else {
				updatedStudentList.add(theStudents.get(i));
			}
		}
		
		scan.close();
		return updatedStudentList;
	}

}
