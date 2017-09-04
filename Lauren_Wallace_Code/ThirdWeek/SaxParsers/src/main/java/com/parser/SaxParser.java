package com.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {
	
	public static void main(String[] args) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {
				
				boolean empFname  = false;
				boolean empLname  = false;
				boolean empNname  = false;
				boolean empSalary = false;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					
					System.out.println("Start Element: " + qName);
					
					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						empFname = true;
					}
					if (qName.equalsIgnoreCase("LASTNAME")) {
						empLname = true;
					}
					if (qName.equalsIgnoreCase("NICKNAME")) {
						empNname = true;
					}
					if (qName.equalsIgnoreCase("SALARY")) {
						empSalary = true;
					}
				}
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println("End Element: " + qName);
				}
				
				public void characters(char ch[], int start, int length) throws SAXException {
					if (empFname) {
						System.out.println("Firstname: " + new String(ch, start, length));
						empFname = false;
					}
					if (empLname) {
						System.out.println("Lastname: " + new String(ch, start, length));
						empLname = false;
					}
					if (empNname) {
						System.out.println("Nickname: " + new String(ch, start, length));
						empNname = false;
					}
					if (empSalary) {
						System.out.println("Salary: " + new String(ch, start, length));
						empSalary = false;
					}
				}
			};
			
			parser.parse("C:/Users/laure/my_git_repos/1708Aug14Code/Lauren_Wallace_Code/ThirdWeek/SaxParsers/src/main/resources/xml/revatureXml.xml", handler);
		} catch (Exception e) {
		       e.printStackTrace();
	     }
	}

}
