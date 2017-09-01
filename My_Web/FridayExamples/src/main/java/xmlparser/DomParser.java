package xmlparser;

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

public class DomParser {

	/*
	 * Read an XML file via DOM XML parser.
	 * The DOM parser parses the entire XML document
	 * and loads it into memory. It then
	 * models the tree structure for easy
	 * traversal/manipulation
	 * 
	 * Warning: The DOM parser is slow and
	 * consumes a lot of memory when it loads
	 * a large XML document.
	 */

	public static void main(String[] args) {

		File xmlFile = new File("C:\\Users\\Nathan\\my_dir_repos\\1708Aug14Code\\My_Web\\FridayExamples\\src\\main\\resources\\xml\\revature.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(xmlFile);

			doc.getDocumentElement().normalize();

			String root = doc.getDocumentElement().getNodeName();
			System.out.println(root);

			NodeList nodes = doc.getElementsByTagName("employee");

			for (int i = 0; i < nodes.getLength(); i++) {

				Node curr = nodes.item(i);
				System.out.println("Current element " + curr.getNodeName());
				
				if (curr.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) curr;
					System.out.println("Id: " + elem.getAttribute("id"));
					System.out.println("Name: " + elem.getElementsByTagName("firstname").item(0).getTextContent() + ' ' + elem.getElementsByTagName("lastname").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
