package xmlparser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample {

	public static void main(String[] args) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {
				
				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;
				
				public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException{
					System.out.println("Start Element: "+qName);
					if(qName.equalsIgnoreCase("firstname")) {
						bfname=true;
					}
					if(qName.equalsIgnoreCase("lastname")) {
						blname = true;
					}
					if(qName.equalsIgnoreCase("nickname")) {
						bnname = true;
					}
					if(qName.equalsIgnoreCase("salary")) {
						bsalary=true;
					}
				} // end start element
				
				public void endElement(String uri, String localName, String qName) throws SAXException{
					System.out.println("End Element: "+ qName);
				} // end end element
				
				public void characters(char ch[], int start, int length) throws SAXException{
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
				}	// end character
				
			}; // end default handler
			saxParser.parse("C:/Users/Katie/my_git_repos/1708Aug14Code/Katherine_Bixby_Code/WEB/Friday/src/main/resources/XML/Revature.xml",handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		
		
		
	}
	
}
