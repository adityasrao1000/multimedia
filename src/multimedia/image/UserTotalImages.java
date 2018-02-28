package multimedia.image;

import java.io.IOException;
import multimedia.database.InitializeMySqlDb;
import java.sql.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/totalUserUploads")
public class UserTotalImages {
		
	@RequestMapping(value = "/{param:.+}",  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("param") String username) throws IOException, SQLException{
		
			final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);  
					 
		    try {

		    	InitializeMySqlDb db =new InitializeMySqlDb();
		    	Connection con = db.mySqlDao(); 
				PreparedStatement ps=con.prepareStatement("select count(*) from imagetable where user_email=?");  
				ps.setString(1,username);  
				ResultSet rs=ps.executeQuery();  
			
				
				if(rs.next()){ 
					int num = rs.getInt(1);
					db.close(ps, rs, con);
					return new ResponseEntity<String>("{\"uploads\":"+num+"}", httpHeaders, HttpStatus.OK);
				}else {
					db.close(ps, rs, con);
					return new ResponseEntity<String>("{\"uploads\":"+0+"}", httpHeaders, HttpStatus.OK);
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
	  }    
}
	

