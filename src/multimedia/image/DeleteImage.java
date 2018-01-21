package multimedia.image;

import java.io.IOException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.sql.*;


@Path("/deleteImage")
public class DeleteImage {
	@Context HttpServletRequest request;
	
	@DELETE
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String id) throws IOException, SQLException{
			
	    	HttpSession session = request.getSession();
	    	String email = (String)session.getAttribute("email");
		    try {
               
		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("delete from imagetable where id=? and user_email=?");  
				ps.setString(1,id);  
				ps.setString(2,email); 
				int i=ps.executeUpdate();  
		
				ps.close();
				con.close();
				if(i==1) {
				return  Response.status(200).entity("success").build();
				}else {
					return  Response.status(401).build();
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	
