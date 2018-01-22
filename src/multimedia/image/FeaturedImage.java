package multimedia.image;

import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
				PreparedStatement ps=con.prepareStatement("select i.id,i.user_email, u.user_name from imagetable i,users u where u.user_email = i.user_email order by RAND() limit 10");  
				PreparedStatement psTags=con.prepareStatement("select tag from tags where id=?");  
				ResultSet rs=ps.executeQuery();  
				
				JSONArray list = new JSONArray();				
				while(rs.next()){  
					JSONObject obj = new JSONObject();
					String id = rs.getString(1);
					obj.put("id",rs.getString(1));
					obj.put("email",rs.getString(2));
					obj.put("username",rs.getString(3));
					psTags.setString(1,id);
					ResultSet rsTags=psTags.executeQuery(); 
					JSONArray tags = new JSONArray();
					//add tags to a separate array
					while(rsTags.next()) {
						tags.add(rsTags.getString(1));
					}
					obj.put("tags", tags);
					list.add(obj);
                    count++;
				}
				psTags.close();
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
	
