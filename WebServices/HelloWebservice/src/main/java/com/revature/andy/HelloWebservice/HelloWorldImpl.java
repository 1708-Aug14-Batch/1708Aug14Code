
package com.revature.andy.HelloWebservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * service implementing bean
 */
@WebService(endpointInterface = "com.revature.andy.HelloWebservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@WebMethod(operationName="hello")
    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
}

