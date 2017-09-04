package com.parser;

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
	 * document & loads it into memory. It then models
	 * a tree structure for easy traversal/manipulation
	 * warning: the DOM parser is slow & consumes a lot 
	 * of memory when it loads a large XML doc.
	 */
	
	public static void main(String[] args) {
		
		File revXML = new File("C:/Users/laure/my_git_repos/1708Aug14Code/Lauren_Wallace_Code/ThirdWeek/Friday/src/main/resources/xml/revatureXml.xml");
		
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document doc = builder.parse(revXML);
		
		//using normalize is good coding practice
		doc.getDocumentElement().normalize();
		String root =doc.getDocumentElement().getNodeName();
		System.out.println(root);
		
		NodeList nodes = doc.getElementsByTagName("employee");
		
		/*
		 * The node object is the primary key data type for the 
		 * entire DOM. A node can be an element node, an 
		 * attribute node, a text node
		 */
		
		for (int i = 0; i < nodes.getLength(); i++) {
			Node curr = nodes.item(i);
			System.out.println("Current element: " + curr.getNodeName());
			
			if(curr.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) curr;
				System.out.println("ID: " + element.getAttribute("id"));
				//element.getTagName("firstname") returns the String of where the Element is 
				//the index must be 0 to get each person's name; if you use i then the program gives a null pointer exception
				System.out.println("Name: " + element.getElementsByTagName("firstname").item(0).getTextContent() + " " + element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nickname: " + element.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
			}
		}
		
		} catch(ParserConfigurationException e) {
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
