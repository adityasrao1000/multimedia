package multimedia.image;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/image")
@Produces("image/jpg")
public class DisplayImage {
	
	@Context
    HttpServletResponse response;
	@javax.ws.rs.core.Context 
	ServletContext context;
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String id) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      
			String driverName = context.getInitParameter("databaseURL");  
			String dbusername = context.getInitParameter("databaseUserName");
			String dbpassword = context.getInitParameter("databasePassword");
			
		    try {

				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection(driverName,dbusername,dbpassword);  
				PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next())	     {         
					Blob b=rs.getBlob(1);
					byte barr[]=b.getBytes(1,(int)b.length());
				    ByteArrayInputStream bin = new ByteArrayInputStream(barr);  
				    BufferedOutputStream bout = new BufferedOutputStream(out);  
				    int ch =0; ;  
				    while((ch=bin.read())!=-1)  
				    {  
				    bout.write(ch);  
				    } 
                    bin.close();  			        
				    bout.close();  
				}else {
					return  Response.status(404).build();
				}
			  
			    con.close();
			    out.close();  
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
          return  Response.status(200).build();
	  }    
	
        
		
}
	
