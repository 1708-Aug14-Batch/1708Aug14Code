package com.xmlparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	/*
	 * In this file, we will read an XML file via DOM
	 * XML Parser. The DOM parser parses the entire XML
	 * document and loads it into memory. It then models
	 * a tree structure for easy traversal and manipulation.
	 * 
	 * Warning: The dom parser is slow and consumes a lot of memory
	 * when it loads a large XML doc.
	 */
	
	public static void main(String[] args) {
		
		File revXML = new File("C:\\Users\\apbon\\my_git_repos\\1708Aug14Code\\Week_3_Internet\\FridayExamples\\src\\main\\resources\\XML\\revature.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); //Create after updating the Maven project with the new dependencies
		
		try {
			DocumentBuilder builder = dbFactory.newDocumentBuilder(); //Create a document builder after creating the factory (Similar to Connection and connection factory)
			
			Document doc = builder.parse(revXML); //Creating the document by parsing in the XML file from FILE
			
			doc.getDocumentElement().normalize(); //Normalizing the document elements?
			
			String root = doc.getDocumentElement().getNodeName();
			System.out.println(root);
		    
			NodeList nodes = doc.getElementsByTagName("employee");
			/*
			 * THe node object is the primary data type for the entire DOM.
			 * A node can be an element node, an attribute node, a text node, etc.
			 * An XML element is everything from the element's start tag to the end tag
			 */
			for(int i = 0; i < nodes.getLength(); i++) {
				Node current = nodes.item(i); //Creating a node based on where the item is in the NodeList
				
				
				
				System.out.println("Current Element " + current.getNodeName());
				
				if(current.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) current;
					System.out.println("ID: " + element.getAttribute("id"));
					System.out.println("Name: " + element.getElementsByTagName("firstname").item(0).getFirstChild().getNodeValue() + " " 
					+ element.getElementsByTagName("lastname").item(0).getFirstChild().getNodeValue());
				}
				
			}
			
			
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
