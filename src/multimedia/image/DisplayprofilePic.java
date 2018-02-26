package multimedia.image;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import multimedia.database.InitializeMySqlDb;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@Controller
@RequestMapping("/displayProfilePic")
public class DisplayprofilePic {
	
	@RequestMapping(value = "/{param:.+}",  method = RequestMethod.GET)
    @ResponseBody
    public void findOne(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		    final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.IMAGE_PNG);
		    
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
			    ios.close();
		    	out.close();
		    	
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		    
	  }    		
}
	
