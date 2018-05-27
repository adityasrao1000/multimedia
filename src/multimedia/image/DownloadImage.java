package multimedia.image;

import multimedia.database.InitializeMySqlDb;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import static multimedia.session.IPAddress.getClientIpAddr;

@Controller
@RequestMapping("/download")
public class DownloadImage {  
  
	@RequestMapping(value = "/{param}", produces={"image/png"}, method = RequestMethod.GET)
    @ResponseBody
    public void findOne(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {  
		
		response.setHeader("Content-Disposition","attachment"); 
		
		ServletOutputStream out;  
		out = response.getOutputStream(); 
		InitializeMySqlDb db = new InitializeMySqlDb();
    	Connection con = db.mySqlDao(); 
		PreparedStatement ps = con.prepareStatement("select photo from imagetable where id=?");  
		ps.setString(1,id);  
	
		ResultSet rs = ps.executeQuery();  
		
		if(rs.next()) {         
			Blob b = rs.getBlob(1);
		
			BufferedOutputStream bout = new BufferedOutputStream(out);  			
		    InputStream os = b.getBinaryStream();
		    BufferedImage image = ImageIO.read(os);

		    ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
		    ImageIO.write(image, "png", ios);
		    
		    //we are logging the IP address the download request came from and the image id
		    try {
			    ps=con.prepareStatement("insert into downloads(id,ip) values(?,?)");  
				ps.setString(1,id);  
				ps.setString(2,getClientIpAddr(request));  
				ps.executeUpdate();
		    }catch(SQLException e) {
		    	
		    }

		    os.close();
		    ios.close();
		    db.close(ps, rs, con);
	}	
  } 
}