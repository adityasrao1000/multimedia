package multimedia.image;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


@Controller
@RequestMapping("/image")
public class DisplayImage {
	
	@RequestMapping(value = "/{param}", produces={"image/png"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		    
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		    
		    final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.IMAGE_PNG);
			
		    try {

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
				    ImageIO.write(image, "png", ios);
					
				    
				    os.close();
				    ios.close();
				}else {
					return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
				}
			  
			    con.close();
			    out.close();  
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
		    }		    
		    return new ResponseEntity<String>("success",httpHeaders,  HttpStatus.OK);
	  }
	
	@RequestMapping(value = "/featured/{param}", produces={"image/png"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> featured(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream(); 
		      	
		    final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.IMAGE_PNG);
		    
		    try {

		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("select photo from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next()) {     
   
					Blob b=rs.getBlob(1);
				    CompressImage com = new CompressImage();
				    com.Compress(out,700, b);
				      
				}else {
					
					return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
				
				}
			  
			    con.close();
			    out.close();  
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
		    }		    
		    return new ResponseEntity<String>("success",httpHeaders, HttpStatus.OK);
	  }
}
	
