package multimedia.image;


import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import multimedia.database.InitializeMySqlDb;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.*;
import java.util.Iterator;


@Path("/image")
@Produces("image/jpg")
public class DisplayImage {
	
	@Context
    HttpServletResponse response;
	
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String id) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      
			
			
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next())	     {         
					Blob b=rs.getBlob(1);
					InputStream os = b.getBinaryStream();
					BufferedImage image = ImageIO.read(os);

					  
				    out = response.getOutputStream(); 
				      
				      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
				      ImageWriter writer = (ImageWriter) writers.next();

				      ImageOutputStream ios = ImageIO.createImageOutputStream(out);
				      writer.setOutput(ios);

				      ImageWriteParam param = writer.getDefaultWriteParam();
				      
				      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				      param.setCompressionQuality(0.4f);
				      writer.write(null, new IIOImage(image, null, null), param);
				      
				      
				      os.close();
				      ios.close();
				      writer.dispose(); 
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
	
