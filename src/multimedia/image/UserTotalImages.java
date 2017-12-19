package multimedia.image;

import java.io.IOException;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/totalUserUploads")
@Produces("application/json")
public class UserTotalImages {
		
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String username) throws IOException, SQLException{
				    
					 
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select count(*) from imagetable where user_email=?");  
				ps.setString(1,username);  
				ResultSet rs=ps.executeQuery();  
			
				
				if(rs.next()){ 
					int num = rs.getInt(1);
					ps.close();
					con.close();
					return  Response.status(200).entity("{\"uploads\":"+num+"}").build();
				}else {
				
					ps.close();
					con.close();
					return  Response.status(200).entity("{\"uploads\":"+0+"}").build();
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	

