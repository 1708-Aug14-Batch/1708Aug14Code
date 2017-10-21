package com.rest.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMessage(@PathParam("param") String message) {
		String output = "this is a fucking message: " + message;
		
		System.out.println("this is the output " + output);
		
		return Response.status(200).entity(output).build();
	}
	
}
