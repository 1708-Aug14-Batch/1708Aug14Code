package xmlparser;


import java.io.File;

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
				boolean bfname = false;
				boolean blname = false;
				boolean bemail = false;
				boolean bsalary = false;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					if (qName.equalsIgnoreCase("FIRSTNAME"))
						bfname = true;
					if (qName.equalsIgnoreCase("LASTNAME"))
						blname = true;
					if (qName.equalsIgnoreCase("EMAIL"))
						bemail = true;
					if (qName.equalsIgnoreCase("SALARY"))
						bsalary = true;
				}
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					
				}
				
				public void characters(char ch[], int start, int length) throws SAXException {
					if (bfname) {
						System.out.println("Firstname: " + new String(ch, start, length));
						bfname = false;
					}
					if (blname) {
						System.out.println("Lastname: " + new String(ch, start, length));
						blname = false;				
					}
					if (bemail) {
						System.out.println("Email: " + new String(ch, start, length));
						bemail = false;
					}
					if (bsalary) {
						System.out.println("Salary: " + new String(ch, start, length));
						bsalary = false;
					}
				}
			
			};
			File revXML = new File("C://Users//Daniel//my_git_repos//1708Aug14Code//Daniel_Fairbanks_Code//Project I//FridayEx//src//main//resources//xml//revature.xml");
			saxParser.parse(revXML, handler);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
