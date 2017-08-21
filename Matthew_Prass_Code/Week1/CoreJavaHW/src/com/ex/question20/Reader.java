package com.ex.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Reader {

	//file to read
	static String filename = "src/com/ex/question20/data.txt";
	

	//reading method and storing of an arraylist of things
	public ArrayList<Things> readThings()
	{
		ArrayList<Things> list = new ArrayList<Things>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String line = null;
			while((line = br.readLine())!= null) {
				Things temp = new Things();
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setAge(Integer.parseInt(states[2]));
				temp.setCollege(states[3]);
				list.add(temp);
			}
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
