
package com.revature.messenger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.Messenger.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
    	System.out.println(text);
        return "Hello " + text;
    }
}

