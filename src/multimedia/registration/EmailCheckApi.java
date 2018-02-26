package multimedia.registration;

import java.io.IOException;
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
@RequestMapping("/emailcheck")
public class EmailCheckApi {

	
    @RequestMapping(value = "/{param}", produces={"application/json"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("param") String email)  throws IOException, SQLException{
			
			final HttpHeaders httpHeaders= new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		    try {
			
		    	EmailCheck e = new EmailCheck();
				if(e.checkIfEmailExists(email))	{ 
					return new ResponseEntity<String>("{\"status\": \"true\"}", httpHeaders, HttpStatus.OK);
				     
				}else {
					return new ResponseEntity<String>("{\"status\": \"false\"}", httpHeaders, HttpStatus.NOT_FOUND);
				}			   
					
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }    		
}
	
