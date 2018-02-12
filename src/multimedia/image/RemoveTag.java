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


@Path("/deleteTag")
public class RemoveTag {
	@Context HttpServletRequest request;
	
	@DELETE
	@Path("/{param}/{tag}")
	public Response getMsg(@PathParam("param") String id, @PathParam("tag") String tag) throws IOException, SQLException{
			
	    	HttpSession session = request.getSession();
	    	String email = (String)session.getAttribute("email");
		    try {
               
		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("delete  from tags  where id=? and tag=? and ?=(select user_email from imagetable where id=?)");  
				ps.setString(1,id);  
				ps.setString(2,tag);
				ps.setString(3,email); 
				ps.setString(4,id); 
				int i=ps.executeUpdate();  
		
				ps.close();
				con.close();
				if(i>1) {
				 System.out.println("more than 1 tag affected");
				}
				System.out.println(i+ " tag deleted");
				return  Response.status(200).entity("success").build();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	
