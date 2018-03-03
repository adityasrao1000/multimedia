package multimedia.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import multimedia.database.InitializeMySqlDb;
import multimedia.registration.SendEmail;
import multimedia.session.RandomToken;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPassword {

 	
	@RequestMapping(value = "/{email:.+}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> findOne(@PathVariable("email") String email, HttpServletRequest request){
 		     		    
 		    //generate token
 		    String token = RandomToken.getToken(35);
 		    try {
 		    	Connection con = new InitializeMySqlDb().mySqlDao(); 
 				PreparedStatement ps=con.prepareStatement("insert into resetpassword(user_email,token) values(?,?)");  
 				
 				ps.setString(1, email);
 				ps.setString(2, token);
 				
 				int i =ps.executeUpdate();  
 			  
 				if(i==1) {
 					SendEmail msg = new SendEmail(token);
 					
 					if(msg.toAddress(email))
 					{
 						return new ResponseEntity<String>("success",HttpStatus.OK);
 					}
 					
 				}
 				return new ResponseEntity<String>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
 				
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    	return new ResponseEntity<String>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
 		    }
				    
 	  }    	  
      
 	  protected int token() {
 		 
 		Random rand = new Random();
 		Integer  i = rand.nextInt(9999) + 1000;
 		int length = String.valueOf(i).length();
 		
 		//in case length of the token is not 4 digits generate another token 
 		if(length!=4){
 		  return token();
 		}
 		
 		return i;

 		}
 	  
 }

 	


