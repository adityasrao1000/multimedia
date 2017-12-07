package multimedia.registration;

import java.io.IOException;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/emailcheck")
@Produces("application/json")
public class EmailCheckApi {

	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String email) throws IOException, SQLException{
			
		    try {
			
		    	EmailCheck e = new EmailCheck();
				if(e.checkIfEmailExists(email))	{ 
					
					return  Response.status(200).entity("{\"status\": \"success\"}").build();
				     
				}else {
					
					return  Response.status(200).entity("{\"status\": \"failed\"}").build();
				}
		
			   
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(500).build();
		    }
	  }    		
}
	
