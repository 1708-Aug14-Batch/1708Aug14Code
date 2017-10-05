package com.revature.soap;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	
	String sayHi(String text);
	String sayBye(int x);

}
