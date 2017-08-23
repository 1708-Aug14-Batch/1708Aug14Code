package com.ex.day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Honda;

public class Serializer {
	
	static String fileName = "src/Honda.car";
	
	public static void main(String[] args) {
		Honda myHonda = new Honda();
		myHonda.setDescription("Awesome");
		writeObject(myHonda);
		Honda hondaFromFile = (Honda) readObject();
		System.out.println(hondaFromFile.getDescription());
	}
	
	static void writeObject(Object object) {
		try(ObjectOutputStream oos =
			new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			oos.writeObject(object);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static Object readObject() {
		Object obj = null;
		try(ObjectInputStream ois =
			new ObjectInputStream(
				new FileInputStream(fileName))) {
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
