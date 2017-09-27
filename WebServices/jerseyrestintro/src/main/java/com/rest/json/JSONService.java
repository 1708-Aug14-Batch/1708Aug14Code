package com.rest.json;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/pop")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON(){
		Track track = new Track();
		track.setTitle("Song");
		track.setSinger("Beyonce");
		return track;
	}
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track){
		
		String result = "Trach saved: " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}


//http://www.mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
