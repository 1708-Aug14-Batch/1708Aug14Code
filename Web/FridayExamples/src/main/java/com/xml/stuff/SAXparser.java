package com.xml.stuff;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXparser {

	/**
	 * The SAX parser is event based parsing, it parses an XML parser step by step rather than all @ once
	 * This is recommended for large XML files because it doesn't take as much time or space
	 */

	public static void main(String[] args) {

		SAXParserFactory spfact = SAXParserFactory.newInstance();
		try {
			//This is just actually retrieving a SAX Parser
			SAXParser saxP = spfact.newSAXParser();

			//We also need a handler
			DefaultHandler handl = new DefaultHandler() {
				//create boolean variables to show which tag the parser is currently parsing
				//so that characters knows what to print out
				String b;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes){
					System.out.println("Start Element: " + qName);
					b = qName;
					
				}
				
				public void characters(char ch[], int start, int length) {
					if(b.equalsIgnoreCase("FIRSTNAME")) {
						System.out.println("First Name : " + new String(ch, start, length));
					}
					if(b.equalsIgnoreCase("LATNAME")) {
						System.out.println("Last Name : " + new String(ch, start, length));
					}
					if(b.equalsIgnoreCase("NICKNAME")) {
						System.out.println("Nickname : " + new String(ch, start, length));
					}
					if(b.equalsIgnoreCase("SALARY")) {
						System.out.println("Salary : " + new String(ch, start, length));
					}
				}
				
				public void endElement(String uri, String localName,
						String qName) throws SAXException {

						System.out.println("End Element :" + qName);

					}
				
			};
			
			saxP.parse("/Users/emmabownes/my_git_repos/1708Aug14Code/Web/FridayExamples/src/main/resources/xml/Revature.xml", handl);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
