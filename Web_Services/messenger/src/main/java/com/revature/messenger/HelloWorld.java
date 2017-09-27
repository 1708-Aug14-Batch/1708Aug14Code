package com.revature.messenger;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

