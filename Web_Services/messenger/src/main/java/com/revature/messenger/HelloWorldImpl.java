/**
 * 
 */

package com.revature.messenger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.messenger.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        System.out.println("text from sayHi(...): " + text);
    	return "Hello " + text;
    }
}

