package com.cisco.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorld {
	
	static String msg = "Hello World";
	
	@GET
	@Produces("text/plain")
	public String getMessage() {
		return msg;
	}
	
	@POST
	@Consumes("text/plain")
	public void updateMsg(String msg) {
		this.msg = msg;
	}

}
