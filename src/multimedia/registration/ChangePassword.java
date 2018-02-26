package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
@RequestMapping("/changePassword")
public class ChangePassword {
 	
 	@RequestMapping(value = "/{old_password}/{new_password}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("old_password") String password_old, @PathVariable("new_password") String password, HttpServletRequest request, HttpServletResponse response){
	
 		
 		 
 			if(!PasswordValidate.isValid(password)) {
 				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
 			}
 		
 			HttpSession session = request.getSession(false);
 			String email = (String)session.getAttribute("email");
 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("update users set user_password=? where user_email=? and user_password=?");  
 				ps.setString(1, password);
 				ps.setString(2, email);
 				ps.setString(3, password_old);
 				int i=ps.executeUpdate();  
 				
 								
 				if(i==1){ 
 					return new ResponseEntity<String>(HttpStatus.OK);
 					
 				}if(i>1) {
 					return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
 				}
 				else {
 					return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
 				}
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
 		    }
				    
 	  }    	       		
 }

 	

