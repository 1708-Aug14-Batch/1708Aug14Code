package xmlparser;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser {

	public static void main(String[] args) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean fn = false;
				boolean ln = false;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					if(qName == "employee") {
						System.out.println("Start Element:" + qName);
						System.out.println("ID:" + attributes.getValue(0));
					}
					if(qName == "firstname") {
						fn = true;
					}
					if(qName == "lastname") {
						ln = true;
					}
				}
				
				public void characters(char ch[], int start, int length) throws SAXException { 
					if(fn) {
						System.out.println("FirstName: " + new String(ch, start, length));
						fn = false;
					}
					if(ln) {
						System.out.println("LastName: " + new String(ch, start, length));
						ln = false;
					}
				}
			};
			saxParser.parse("src/test/resources/xml/revature.xml", handler);
		}
		catch(Exception e) {
			
		}
		
	}
	
}
