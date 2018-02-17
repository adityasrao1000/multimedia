package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;


@Path("/verifyPassword")
 public class PasswordVerify {
 		
 	
 	@Context private HttpServletRequest request;
 	
 	@GET
 	@Path("/{old_password}")
	public Response changePassword( @PathParam("old_password") String password){
 				 
 			HttpSession session = request.getSession(false);
 			String email = (String)session.getAttribute("email");

 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("select user_email from users where user_password=? and user_email=?");  
 				ps.setString(1, password);
 				ps.setString(2, email);
 				
 				ResultSet rs=ps.executeQuery();  
 												
 				if(rs.next()){ 
 					
 					return  Response.status(200).entity("true").build();
 					
 				}else {
 					
 					return  Response.status(404).entity("false").build();
 				}
 				
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		   
 		    	return  Response.status(404).entity(false).build();
 		    }
				    
 	  }    	       		
 }

 	


