package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import multimedia.database.InitializeMySqlDb;


@Controller
@RequestMapping("/verifyPassword")
 public class PasswordVerify {
 		
 	@RequestMapping(value = "/{old_password}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("old_password") String password, HttpServletRequest request, HttpServletResponse response){
 				 
 			HttpSession session = request.getSession(false);
 			String email = (String)session.getAttribute("email");

 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("select user_email from users where user_password=? and user_email=?");  
 				ps.setString(1, password);
 				ps.setString(2, email);
 				
 				ResultSet rs=ps.executeQuery();  
 												
 				if(rs.next()){ 
 					return new ResponseEntity<String>("true", HttpStatus.OK);
 					
 				}else {
 					
 					return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
 				}
 				
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    	return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
 		    }
				    
 	  }    	       		
 }

 	


