package multimedia.image;

import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/featuredimage")
public class FeaturedImage {
		
	
	@Context private HttpServletRequest httpRequest;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public Response getMsg() throws IOException, SQLException{
			    
		    int count=0;
			 
		    try {
		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
				PreparedStatement ps=con.prepareStatement("select id from imagetable order by RAND() limit 10");  
 
				ResultSet rs=ps.executeQuery();  
				
				JSONArray list = new JSONArray();
				
				while(rs.next()){  
					 
					list.add(rs.getString(1));
                    count++;
				}
				ps.close();
				con.close();
				if(count>0) {
				return  Response.status(200).entity(list.toJSONString()).build();
				}else {
					return  Response.status(404).build();
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	
