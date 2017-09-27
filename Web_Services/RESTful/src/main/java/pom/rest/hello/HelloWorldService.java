package pom.rest.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {
	
	@GET
	@Path("/{param}")
	public Response getMessage(@PathParam("param") String message) {
		String output = "hello! Message: " + message;
		System.out.println(output);
		
		return Response.status(200).entity(output).build();
	}
	
}
