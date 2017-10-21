package com.rev.setup;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	public String sayHi(String x);
	public String sayBye(String x);
	
}
