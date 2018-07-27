package com.infy.api;
import java.util.ArrayList;


import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import com.infy.bean.BuildDetails;
import com.infy.resources.AppConfig;
import com.infy.resources.JSONParser;
import com.infy.service.JavaApplication;

@Path("/BuildAPI")
public class BuildAPI {		
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Details")
	public Response checkDetails(String dataRecieved) throws Exception {
		Response response = null;

		try {
			System.out.println("ueh3u"+dataRecieved);
					
					JavaApplication application=new JavaApplication();
					BuildDetails buildDetails = JSONParser.fromJson(dataRecieved, BuildDetails.class);
					
					String checkDetails = application.CheckDetails(buildDetails);
				     String returnString = JSONParser.toJson(buildDetails);
				     response=Response.status(Status.OK).entity(returnString).build();
			
		} catch (Exception e) {
			BuildDetails beanForMessage = new BuildDetails();
			beanForMessage.setMessage(AppConfig.PROPERTIES.getProperty(e
					.getMessage()));
			String returnString = JSONParser.toJson(beanForMessage);
			response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();
		}
		return response;
   
	}
	
	
	

}
