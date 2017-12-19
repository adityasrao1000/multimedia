package multimedia.image;


import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/displayProfilePic")
@Produces("image/jpg")
public class DisplayprofilePic {
	
	@Context
    HttpServletResponse response;
	
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String id) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      			
			
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select profile_picture from users where user_email=?");  
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
					
		    }catch(NullPointerException e) {
		    	e.printStackTrace();
		    	FileInputStream fi = new FileInputStream("C:\\Users\\Aditya rao\\Pictures\\default.jpg");
		    	byte[] b = new byte[fi.available()];
		    	int i;
		    	int j =0;
		    	while((i =fi.read())!=-1) {
		    		b[j]=(byte)i;
		    		j++;
		    		
		    	}
		    	ByteArrayInputStream bin = new ByteArrayInputStream(b);  
			    BufferedOutputStream bout = new BufferedOutputStream(out);  
			    int ch =0; ;  
			    while((ch=bin.read())!=-1)  
			    {  
			    bout.write(ch);  
			    } 
			    fi.close();
                bin.close();  			        
			    bout.close();
	
		    	out.close();
		    	return  Response.status(200).build();
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    	return  Response.status(404).build();
		    }
		    
          return  Response.status(200).build();
	  }    
	
        
		
}
	
