package multimedia.image;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import multimedia.database.InitializeMySqlDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@Controller
@RequestMapping("/rateImage")
public class RateImage {
	
	@RequestMapping(value = "/{param}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> findOne(@PathVariable("param") boolean rating, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
			
	    	
		    try {
               
		    	InitializeMySqlDb db = new InitializeMySqlDb();
		    	Connection con = db.mySqlDao();
				PreparedStatement ps=con.prepareStatement("insert into rating values(?,?,?)"); 
				
		        try {
		        	int i = ps.executeUpdate(); 
		        	if(i==1) {
		        		return new ResponseEntity<String>("success", HttpStatus.OK);
		            }
		        }catch(SQLException ex) {
		        	return new ResponseEntity<String>("failure", HttpStatus.BAD_REQUEST);
		        }
		        finally {
		        	db.close(ps, con);
		        }
				
				return new ResponseEntity<String>("failure", HttpStatus.NOT_FOUND);
				
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
	  }    
}
	

