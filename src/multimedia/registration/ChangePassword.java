package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;



@Path("/changePassword")
public class ChangePassword {
 		
 	
 	@Context private HttpServletRequest request;
 	
 	@PUT
 	@Path("/{old_password}/{new_password}")
	public Response changePassword(@PathParam("old_password") String password_old, @PathParam("new_password") String password){
 		
 		 
 			if(!PasswordValidate.isValid(password)) {
 				return  Response.status(404).build();
 			}
 		
 			HttpSession session = request.getSession(false);
 			String email = (String)session.getAttribute("email");
 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("update users set user_password=? where user_email=? and user_password=?");  
 				ps.setString(1, password);
 				ps.setString(2, email);
 				ps.setString(3, password_old);
 				int i=ps.executeUpdate();  
 				
 								
 				if(i==1){ 
 					return  Response.status(200).build();
 					
 				}if(i>1) {
 					return  Response.status(500).build();
 				}
 				else {
 					return  Response.status(404).build();
 				}
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    	return  Response.status(404).build();
 		    }
				    
 	  }    	       		
 }

 	

