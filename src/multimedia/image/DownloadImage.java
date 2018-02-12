package multimedia.image;

import javax.ws.rs.core.Context;
import multimedia.database.InitializeMySqlDb;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@Path("/download")
@Produces("image/png")
public class DownloadImage {  
  
	@Context
	HttpServletResponse response;

	@GET
	@Path("/{param}")
	public void download(@PathParam("param") String id) throws IOException, SQLException, ClassNotFoundException {  
		
		response.setHeader("Content-Disposition","attachment"); 
	
		
		ServletOutputStream out;  
		out = response.getOutputStream(); 
		Connection con = new InitializeMySqlDb().mySqlDao();
		PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
		ps.setString(1,id);  
	
		ResultSet rs=ps.executeQuery();  
		
		if(rs.next()) {         
			Blob b=rs.getBlob(1);
		
			BufferedOutputStream bout = new BufferedOutputStream(out);  
			
		    InputStream os = b.getBinaryStream();
		    BufferedImage image = ImageIO.read(os);
		    
		    ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
		    ImageIO.write(image, "png", bout);
			
		    
		    os.close();
		    ios.close();
	}	
  } 
}

