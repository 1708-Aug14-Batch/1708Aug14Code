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

public class DOMParser {

	public static void main(String[] args) {
		File revXML = new File(
				"C://Users//oracl//my_git_repos//1708Aug14Code//CoreJava//fridayexamples//src//main//resources//xml//revature.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = dbFactory.newDocumentBuilder();

			Document doc = builder.parse(revXML);
			
			doc.getDocumentElement().normalize();
			String root = doc.getDocumentElement().getNodeName();
			
			System.out.println(root);
			
			NodeList nodes = doc.getElementsByTagName("employee");
			
			for(int i=0; i < nodes.getLength(); i++) {
				
				Node curr = nodes.item(i);
				
				System.out.println("Current Element " + curr.getNodeName());
				
				if(curr.getNodeType()== Node.ELEMENT_NODE) {
					Element element = (Element)curr;
					System.out.println("ID: " + element.getAttribute("id"));
					System.out.println("Name: " + element.getElementsByTagName("firstname").item(0).getTextContent() + " " +
					element.getElementsByTagName("lastname").item(0).getTextContent());
				}
				
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
