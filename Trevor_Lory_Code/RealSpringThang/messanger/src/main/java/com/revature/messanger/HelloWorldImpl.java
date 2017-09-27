
package com.revature.messanger;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * Service Implementing Bean
 */
@WebService(endpointInterface = "com.revature.messanger.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@WebMethod(operationName="hello")
    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
}

