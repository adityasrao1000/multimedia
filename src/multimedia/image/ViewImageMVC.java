package multimedia.image;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.sql.*;


@Path("/viewimage")
@Produces("image/png")
public class ViewImageMVC {
	

	
	@GET
	@Path("/{param}")
	public Response getMsg1(@PathParam("param") String id, @Context HttpServletResponse response,@Context HttpServletRequest request) throws IOException, SQLException{
		      	
			
		    try {
		    	InitializeMySqlDb db = new InitializeMySqlDb();
		    	Connection con = db.mySqlDao();
				PreparedStatement ps=con.prepareStatement("select id from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next()) {   
					request.setAttribute("id", id);
					RequestDispatcher rd=request.getRequestDispatcher("/imagedetails");  
		            rd.forward(request, response);  
					db.close(ps, rs, con); 	
					return  Response.status(200).build();
				}else {
					db.close(ps, rs, con); 
					return  Response.status(404).build();
				}
			  
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }		    
	  }
}
	
