package xmlparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DOMParser {
	/*
	 * About to read an XML file via DOM XML Parser.
	 * The DOM parser parses the entire XML documents and loads it into memory.
	 * It then models a tree structure for easy traversal/manipulation.
	 * WARNING: The DOM Parser is slow and consumes a lot of memory when it loads a large XML doc.
	 */
	public static void main(String[] args) {
		try {
			File revXML = new File("C://Users//Daniel//my_git_repos//1708Aug14Code//Daniel_Fairbanks_Code//Project I//FridayEx//src//main//resources//xml//revature.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(revXML);
			doc.getDocumentElement().normalize();
			
			NodeList nodes = doc.getElementsByTagName("employee");
			for (int i=0; i < nodes.getLength(); i++) {
				Node cur = nodes.item(i);
				Element e = (Element)cur;
				System.out.println(cur.getAttributes().item(0));
				System.out.println(e.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println(e.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println(e.getElementsByTagName("email").item(0).getTextContent());
				System.out.println(e.getElementsByTagName("salary").item(0).getTextContent());
				System.out.println();
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
