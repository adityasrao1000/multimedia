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
		    	InitializeMySqlDb db = new InitializeMySqlDb();
		    	Connection con = db.mySqlDao();
	
				PreparedStatement ps=con.prepareStatement("SELECT count(t.id), i.user_email from tags t INNER JOIN imagetable i ON t.id=i.id where t.id=?");  
				ps.setString(1,id);  
				ResultSet rs = ps.executeQuery(); 
				
				if(rs.next()) {
				
					if(rs.getInt(1)<10 && rs.getString(2).equals(email)) {
							
							tag = tag.trim().toLowerCase();
							tag = tag.replaceAll("\\s"," "); 
							
							if(tag.length()>30 && tag.length()>=2) {
								return  Response.status(400).entity("failed").build();
							}
							
							ps=con.prepareStatement("insert into tags(id,tag,upload_date) values(?,?,(select upload_date from imagetable where id=?))");
							ps.setString(1, id);
							ps.setString(2, tag);
							ps.setString(3, id);
							int i = ps.executeUpdate();
							
							//if one row updated then tag has been successfully inserted into the database					
							if(i==1) {
								System.out.println(i+" tag added");
								db .close(ps,rs,con);
								return  Response.status(200).entity("success").build();
							}						
						
						}
						
					}
				
				
				db .close(ps,rs,con);
				return  Response.status(400).entity("failed").build();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
	  }    
	
        
		
}
	
