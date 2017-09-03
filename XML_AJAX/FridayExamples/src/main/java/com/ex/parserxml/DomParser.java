package com.ex.parserxml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
// https://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser/

public class DomParser {
	/*
	 * The first few methods will read an XML file via DOM XML parser. The DOM
	 * parser will parse the entire XML document and load it into memory. Then
	 * it will model a tree-structure for easy traversal/manipulation of the
	 * stored data
	 * 
	 * WARNING: The DOM parser is slow and consumes a lot of memory when it
	 * loads a large XML doc
	 */

	/*
	 * SAX parser is working differently with a DOM parser, it neither load any
	 * XML document into memory nor create any object representation of the XML
	 * document. Instead, the SAX parser use callback function
	 * (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML
	 * document structure.
	 */

	public static String XmlFolderFilePath = "C:/Users/Surplus/my_git_repos/1708Aug14Code/XML_AJAX/FridayExamples/src/main/resources/xml/";

	public static void main(String[] args) {

		readXMLFileDOM1();
		readXMLFileDOM2();
		readXMLFileDOM3();

		readXMLFileSAX();

	}

	private static void readXMLFileDOM1() {

		try {

			File revXML = new File(XmlFolderFilePath + "revature.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(revXML);

			// optional but recommended step
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			String root = doc.getDocumentElement().getNodeName();
			if (root == null) {
				System.out.println("Error: root node not found");
				return;
			}
			System.out.println("Root element: " + root);

			NodeList nodes = doc.getElementsByTagName("employee");
			/*
			 * The node object is the primary data type for the entire DOM A
			 * node can be an element node, an attribute node, a text node, etc.
			 * An XML element is everything from the element's start tag to the
			 * end tag
			 */

			for (int i = 0; i < nodes.getLength(); i++) {
				Node curr = nodes.item(i);

				System.out.println("Current element: " + curr.getNodeName());

				if (curr.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) curr;

					System.out.println("\tAttribute ID: " + element.getAttribute("ID"));
					System.out.println("\tName: " + element.getElementsByTagName("firstName").item(0).getTextContent()
							+ " " + element.getElementsByTagName("lastName").item(0).getTextContent());

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

	/*
	 * DOM XML Parser Example This example shows you how to get the node by
	 * �name�, and display the value.
	 */
	private static void readXMLFileDOM2() {
		try {

			File fXmlFile = new File(XmlFolderFilePath + "staff.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println(
							"First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println(
							"Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Looping the Node This example reads the same "staff.xml", and showing you
	 * how to loop the node one by one, and print out the node name and value,
	 * and also the attribute if any.
	 */
	private static void readXMLFileDOM3() {
		try {

			File file = new File(XmlFolderFilePath + "staff.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = dBuilder.parse(file);

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {

				printNote(doc.getChildNodes());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printNote(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());

					}

				}

				if (tempNode.hasChildNodes()) {

					// loop again if has child nodes
					printNote(tempNode.getChildNodes());

				}

				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

			}

		}

	}

	private static void readXMLFileSAX() {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						bfname = true;
					}

					if (qName.equalsIgnoreCase("LASTNAME")) {
						blname = true;
					}

					if (qName.equalsIgnoreCase("NICKNAME")) {
						bnname = true;
					}

					if (qName.equalsIgnoreCase("SALARY")) {
						bsalary = true;
					}

				}

				public void endElement(String uri, String localName, String qName) throws SAXException {

					System.out.println("End Element :" + qName);

				}

				public void characters(char ch[], int start, int length) throws SAXException {

					if (bfname) {
						System.out.println("First Name : " + new String(ch, start, length));
						bfname = false;
					}

					if (blname) {
						System.out.println("Last Name : " + new String(ch, start, length));
						blname = false;
					}

					if (bnname) {
						System.out.println("Nick Name : " + new String(ch, start, length));
						bnname = false;
					}

					if (bsalary) {
						System.out.println("Salary : " + new String(ch, start, length));
						bsalary = false;
					}

				}

			};

			saxParser.parse("c:\\file.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}