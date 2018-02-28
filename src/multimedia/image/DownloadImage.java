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

@Controller
@RequestMapping("/download")
public class DownloadImage {  
  
	@RequestMapping(value = "/{param}", produces={"image/png"}, method = RequestMethod.GET)
    @ResponseBody
    public void findOne(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {  
		
		response.setHeader("Content-Disposition","attachment"); 
		
		ServletOutputStream out;  
		out = response.getOutputStream(); 
		InitializeMySqlDb db =new InitializeMySqlDb();
    	Connection con = db.mySqlDao(); 
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
		    System.out.println(getClientIpAddr(request));
		    os.close();
		    ios.close();
		    db.close(ps, rs, con);
	}	
  } 
	public static String getClientIpAddr(HttpServletRequest request) {  
	    String ip = request.getHeader("X-Forwarded-For");  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_X_FORWARDED");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_CLIENT_IP");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_FORWARDED_FOR");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_FORWARDED");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("HTTP_VIA");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getHeader("REMOTE_ADDR");  
	    }  
	    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}
}