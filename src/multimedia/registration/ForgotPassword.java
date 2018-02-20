package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import multimedia.registration.SendEmail;

@Path("/forgotPassword")
public class ForgotPassword {

 	
 	@PUT
 	@Path("/{email}")
	public Response changePassword(@PathParam("old_password") String email){
 		     		    
 		    //generate 4 digit token
 		    int token = token();
 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("insert into resetpassword(email,token) values(?,?)");  
 				
 				ps.setString(1, email);
 				ps.setInt(2, token);
 				
 				int i=ps.executeUpdate();  
 				
 				if(i==1) {
 					SendEmail msg = new SendEmail(token);
 					if(msg.toAddress(email)) {
 						Response.status(200).entity("success").build();
 					}
 				}
 				return  Response.status(500).entity("failed").build();
 				
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    	return  Response.status(500).entity("failed").build();
 		    }
				    
 	  }    	  
      
 	  protected int token() {
 		 
 		Random rand = new Random();
 		Integer  i = rand.nextInt(9999) + 1000;
 		int length = String.valueOf(i).length();
 		
 		//in case length of the token is not 4 digits generate another token 
 		if(length!=4){
 		  return token();
 		}
 		
 		return i;

 		}
 	  
 }

 	


