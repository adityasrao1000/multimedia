package multimedia.image;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;


@Path("/displayProfilePic")
@Produces("image/png")
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
					BufferedOutputStream bout = new BufferedOutputStream(out);  
					
				    InputStream os = b.getBinaryStream();
				    BufferedImage image = ImageIO.read(os);
				    ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
				    ImageIO.write(image, "png", ios);
							    
				    os.close();
				    bout.close();
				    ios.close(); 							    
				}else {
					return  Response.status(404).build();
				}
			  
			    con.close();
			    out.close();  
					
		    }catch(NullPointerException e) {
		    	System.out.println("NullPointerException: Loading default profile picture");
		    	FileInputStream fi = new FileInputStream("C:\\Users\\Aditya\\Pictures\\Saved Pictures\\default.png");
		    	BufferedOutputStream bout = new BufferedOutputStream(out);  
				BufferedImage image = ImageIO.read(fi);
			    ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
			    ImageIO.write(image, "png", ios);
			    
			    fi.close();		        
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
	
