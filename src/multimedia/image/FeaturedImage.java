package multimedia.image;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import multimedia.database.InitializeMySqlDb;
import java.sql.*;


@Controller
@RequestMapping("/featuredimage")
public class FeaturedImage {
		
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getMsg() throws IOException, SQLException{
		
			final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);  
		    int count=0;
			
		    try {
		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
				PreparedStatement ps=con.prepareStatement("select i.id,i.user_email, u.user_name from imagetable i,users u where u.user_email = i.user_email order by RAND() limit 10");  
				PreparedStatement psTags=con.prepareStatement("select tag from tags where id=?");  
				ResultSet rs=ps.executeQuery();  
				
				JSONArray list = new JSONArray();				
				while(rs.next()){  
					JSONObject obj = new JSONObject();
					String id = rs.getString(1);
					obj.put("id",rs.getString(1));
					obj.put("email",rs.getString(2));
					obj.put("username",rs.getString(3));
					psTags.setString(1,id);
					ResultSet rsTags=psTags.executeQuery(); 
					JSONArray tags = new JSONArray();
					//add tags to a separate array
					while(rsTags.next()) {
						tags.add(rsTags.getString(1));
					}
					obj.put("tags", tags);
					list.add(obj);
                    count++;
				}
				psTags.close();
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
	
