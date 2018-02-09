package multimedia.image;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


@Path("/image")
@Produces("image/png")
public class DisplayImage {
	
	@Context
    HttpServletResponse response;
	
	@GET
	@Path("/{param}")
	public Response getMsg1(@PathParam("param") String id) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      	
			
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next()) {         
					Blob b=rs.getBlob(1);
				
					BufferedOutputStream bout = new BufferedOutputStream(out);  
				    int ch =0; ; 
				    InputStream os = b.getBinaryStream();
				    while((ch=os.read())!=-1)  
				    {  
				    bout.write(ch);  
				    } 
					
				      
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
	
	@GET
	@Path("/featured/{param}")
	public Response getMsg(@PathParam("param") String id) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      	
			
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next()) {         
					Blob b=rs.getBlob(1);
				
				    CompressImage com = new CompressImage();
				    com.Compress(out, .4f, b);
					
				      
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
	
