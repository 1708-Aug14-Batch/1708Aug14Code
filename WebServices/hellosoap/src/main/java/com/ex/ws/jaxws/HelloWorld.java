package com.ex.ws.jaxws;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface HelloWorld {
	
	@WebMethod
	String getHelloWorldAsString(String name);

}
