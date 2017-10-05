package xmlParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMparserLoop {
	public static void main(String[] args){
		File revXML = new File("C:/Users/1Z4XS/workspace/examplesXMLParsing/src/main/resources/xml/Revature.xml");
		
		try{
			DocumentBuilderFactory dbFactoury=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbFactoury.newDocumentBuilder();
			Document doc = builder.parse(revXML);
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			if (doc.hasChildNodes())
				printNote(doc.getChildNodes());

		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private static void printNote(NodeList childNodes) {
		// TODO Auto-generated method stub
		for (int count = 0; count < childNodes.getLength(); count++) {

			Node tempNode = childNodes.item(count);
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
}

