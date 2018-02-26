package multimedia.image;

import java.io.IOException;
import org.json.simple.JSONArray;
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
import java.sql.*;

@Controller
@RequestMapping("/tags")
public class DisplayTags {
		

	@SuppressWarnings("unchecked")
    @RequestMapping(value = "/{param}", produces={"application/json"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("param") String id)  throws IOException, SQLException{
		
			final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);    
		    int count=0;
			 
		    try {
		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
				PreparedStatement ps=con.prepareStatement("select tag from tags where id=?");  
                ps.setString(1,id);
				ResultSet rs=ps.executeQuery();  
				
				JSONArray list = new JSONArray();				
				while(rs.next()){  
					list.add(rs.getString(1));
                    count++;
				}
				ps.close();
				con.close();
				if(count>0) {
					return new ResponseEntity<String>(list.toJSONString(), httpHeaders, HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
		    }		    
	  }    	       		
}