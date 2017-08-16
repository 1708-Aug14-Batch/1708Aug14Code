package com.ex.StudentIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentIO {
	
	static String filename = "src/com/ex/StudentIO/students.txt";
	
	public static void writeStudent(Student s)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			String txt = "";
			txt = txt.concat(s.getFirstname()+":");
			txt = txt.concat(s.getLastname()+":");
			txt = txt.concat(((Integer)s.getStudentID()).toString()+"\n");
			
			bw.write(txt);
		} catch (IOException e) {
			System.out.println("IOException encountered...");
		}
	}
	
	public static void writeAllStudents(Map<Integer, Student> map)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));) {
			for(Map.Entry<Integer,Student> entry : map.entrySet()) {
				String txt = "";
				txt = txt.concat(entry.getValue().getFirstname()+":");
				txt = txt.concat(entry.getValue().getLastname()+":");
				txt = txt.concat(((Integer)entry.getValue().getStudentID()).toString()+"\n");
				
				bw.write(txt);
			}
		} catch (IOException e) {
			System.out.println("IOException encountered...");
		}
	}
	
	public static Map<Integer, Student> readStudents() 
	{
		//ArrayList<Student> list = new ArrayList<Student>();
		Map<Integer, Student> map = new TreeMap<Integer, Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line=br.readLine()) != null) {
				Student temp = new Student();
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setStudentID(Integer.parseInt(states[2]));
				map.put(Integer.parseInt(states[2]), temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void deleteStudentByID(int ID, Map<Integer, Student> map)
	{
		map.remove(ID);
		writeAllStudents(map);
	}
	
	public static void updateStudentByID(int ID, Student s, Map<Integer, Student> map)
	{
		map.put(ID, s);
		writeAllStudents(map);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter firstname");
		String firstname = scan.nextLine();
		System.out.println("Enter lastname");
		String lastname = scan.nextLine();
		System.out.println("Enter firstname");
		int studentID = Integer.parseInt(scan.nextLine());
		Student s1 = new Student(firstname, lastname, studentID);
		//writeStudent(s1);
		//Map<Integer, Student> map = readStudents();
		//deleteStudentByID(218791, map);
		//updateStudentByID(346752, s1, map);
	}

}
