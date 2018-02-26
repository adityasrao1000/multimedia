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
import javax.servlet.http.HttpSession;
import java.sql.*;


@Controller
@RequestMapping("/deleteImage")
public class DeleteImage {
	
	@RequestMapping(value = "/{param}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> findOne(@PathVariable("param") String id, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
			
	    	HttpSession session = request.getSession();
	    	String email = (String)session.getAttribute("email");
		    try {
               
		    	Connection con = new InitializeMySqlDb().mySqlDao();
				PreparedStatement ps=con.prepareStatement("delete from imagetable where id=? and user_email=?");  
				ps.setString(1,id);  
				ps.setString(2,email); 
				int i=ps.executeUpdate();  
		
				ps.close();
				con.close();
				if(i==1) {
					return new ResponseEntity<String>("success", HttpStatus.OK);
				}else {
					return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
		    
	  }    
	
        
		
}
	
