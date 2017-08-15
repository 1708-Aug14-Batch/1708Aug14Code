package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Honda;

public class Serialization {
	

	static String filename = "src/com/ex/io/log.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Honda honda = new Honda("tacos",100,"hi");
//		honda.setDescription("hi");
//		honda.setMpg(100);
//		honda.setModel("tacos");
		
		//writeObject(honda);
		
		Honda h = (Honda) readObject();
		
		System.out.println(h.getDescription() + h.getMpg() + h.getModel());
	}

	static Object readObject() {
		Object obj = null;
		
		try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream(filename))){
			try {
				obj = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	static void writeObject(Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(filename))){
			oos.writeObject(obj);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
