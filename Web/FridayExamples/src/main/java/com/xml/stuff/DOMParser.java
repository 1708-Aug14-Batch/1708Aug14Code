package com.xml.stuff;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	
	/**
	 * We're going to read an XML file using a DOM XML parser
	 * it parses the entire XML document, then loads it into memory
	 * models a tree structure for easy traversal / manipulation
	 * 
	 * Warning: This is prett slow & consumes a lot of memory for large xML documents
	 */
	
	public static void main(String[] args) {
		File revxml = new File("/Users/emmabownes/my_git_repos/1708Aug14Code/Web/FridayExamples/src/main/resources/xml/Revature.xml");
		
		DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder dBuild= dbFact.newDocumentBuilder();
			
			Document doc = dBuild.parse(revxml);
			
			//The following is not necessary, however it is recomended.
			//We are going to normalize our document
			
			doc.getDocumentElement().normalize();
			
			String root = doc.getDocumentElement().getNodeName();
			System.out.println(root);
			
			//Node is the primary data type for the entire DOM
			// a Node can be an element, an attribute node, a text node, etc.
			NodeList nodes = doc.getElementsByTagName("employee");
			
			for(int i=0;i<nodes.getLength();i++) {
				
				//gotta grab the node
				Node curr = nodes.item(i);
				
				
				//gotta get the node name
				System.out.println("Current Element: "+curr.getNodeName());
				
				if(curr.getNodeType()== Node.ELEMENT_NODE) {
					Element e = (Element) curr;
					
					String id = e.getAttribute("id");
					System.out.println("id "+ id);
					
					
					System.out.println("Name: "+e.getElementsByTagName("firstname").item(0).getTextContent()+
							" "+e.getElementsByTagName("lastname").item(0).getTextContent());
					
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
