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

public class DomParser 
{
	//in this file, we will read an xml via dom xml parser.
	//the dom parser parses the entire xml document and loads it into memory.
	//models a tree structure for easy traversal/manipulation
	//warning: slow and consumes a lor of memory
	
	
	public static void main(String[] args) {
		File revXML = new File("C://Users//Matt//my_git_repos//1708Aug14Code//Matthew_Prass_Code//Week 3//fridayexamples//src//main//resources//xml//revature.xml");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			
			try {
				Document doc = builder.parse(revXML);
				doc.getDocumentElement().normalize();
				String root = doc.getDocumentElement().getNodeName();
				System.out.println(root);
				
				NodeList nodes = doc.getElementsByTagName("employee");
				//Node - primary data type for entire dom. element node, attribute node, etc.
				//Element - 
				for(int i = 0; i< nodes.getLength(); i++)
				{
					Node curr = nodes.item(i);
					System.out.println("Current Element: " + curr.getNodeName());
					
					if(curr.getNodeType() ==  Node.ELEMENT_NODE) {
						Element element = (Element) curr;
						System.out.println("id: " + element.getAttribute("id"));
						System.out.println("Name: "+ element.getElementsByTagName("firstname").item(0).getTextContent());
					}
				}
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
