package multimedia.image;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.sql.*;


@Path("/addTag")
public class AddTag {
	@Context HttpServletRequest request;
	
	@GET
	@Path("/{id}")
	public Response getMsg(@PathParam("id") String id,@QueryParam("tag") String tag) throws  SQLException{
		
	    	HttpSession session = request.getSession();
	    	String email = (String)session.getAttribute("email");
		    try {
                
		    	Connection con = new InitializeMySqlDb().mySqlDao();
		    
				PreparedStatement ps=con.prepareStatement("select * from tags where id=? limit 1");  
				ps.setString(1,id);  
				ResultSet rs = ps.executeQuery(); 
				
				if(rs.next()){
					
					ps=con.prepareStatement("select count(*) from tags where id=?");
					ps.setString(1, id);
					rs = ps.executeQuery();
					
					if(rs.next()) {
					
						if(rs.getInt(1)<10) {
							
							ps=con.prepareStatement("select user_email from imagetable where id=?");
							ps.setString(1, id);
							rs = ps.executeQuery();
							
							if(rs.next())
							if(rs.getString(1).equals(email)) {
								ps=con.prepareStatement("insert into tags(id,tag,upload_date) values(?,?,(select upload_date from imagetable where id=?))");
								ps.setString(1, id);
								ps.setString(2, tag);
								ps.setString(3, id);
								int i = ps.executeUpdate();
								
						
								
								if(i==1) {
									return  Response.status(200).entity("success").build();
								}
								
								return  Response.status(404).entity("failed").build();
							}
							
							return  Response.status(404).entity("failed").build();
						}
					}
				}
				
				return  Response.status(404).entity("failed").build();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	
