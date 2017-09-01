package com.revature.andy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserExample {
	/*
	 * Read XML file using DOM XML parser
	 * 
	 * DOMParser parses the entire XML document and loads it into Memory. It then
	 * models a tree structure for easy traverse/manipulation
	 * 
	 * WARNING: DOMParse is slow and uses alot of memory when it loads large XML
	 * document.
	 */

	public static void main(String[] args) {

		File revXML = new File(
				"C:/Users/Creus/my_git_repos/1708Aug14Code/XML/Friday/src/main/resources/XML/revature.xml");

		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				boolean mn = false;
				boolean salary = false;
				
				public void startElement(String uri, String localName, String qName, Attributes att) {
					System.out.println("Starting Element: " + qName);
					if(qName.equals("firstname")) {
						fn = true;
					}
					if(qName.equals("lastname")) {
						ln = true;
					}
					if(qName.equals("middlename")) {
						mn = true;
					}
					if(qName.equals("salary")) {
						salary = true;
					}
				}
				
				public void endElement(String uri, String localName, String qName) {
					System.out.println("End element: " + qName);
				};
				
				public void characters(char ch[], int start, int length) {
					if(fn) {
						System.out.println("First name: " + new String(ch, start, length));
						fn=false;
					}
					if(ln) {
						System.out.println("Last name: " + new String(ch, start, length));
						ln=false;
					}
					if(mn) {
						System.out.println("Middle name: " + new String(ch, start, length));
						mn=false;
					}
					if(salary) {
						System.out.println("Salary: " + new String(ch, start, length));
						salary=false;
					}
				}
				
			};

			saxParser.parse(revXML , handler);
			
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
		
		/*
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			
			Document doc = builder.parse(revXML);
			
			//optional but recommended
			//normalize
			doc.getDocumentElement().normalize();
				
			String root = doc.getDocumentElement().getNodeName();
			
			NodeList nodes = doc.getElementsByTagName("empolyee");

			// Node object is the primary data type for the entire DOM.
			// Node can be an element node, an attribute node, a text node, etc
			// An XML element is everything from the elmeen's start tab to the end tag
			
			System.out.println(root);
			
			for(int i = 0; i < nodes.getLength(); i++) {
				Node curr = nodes.item(i);
				System.out.println("Current element: " + curr.getNodeName());
				
				if(curr.getNodeType()==Node.ELEMENT_NODE) {
					Element ele = (Element) curr;
					System.out.println("ID: " + ele.getAttribute("id"));
					System.out.println("Name: " 
					+ ele.getElementsByTagName("firstname").item(0).getTextContent() +
				" " + ele.getElementsByTagName("lastname").item(0).getTextContent());
				}
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
}
