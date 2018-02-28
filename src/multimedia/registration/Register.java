package multimedia.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import multimedia.database.InitializeMySqlDb;


@Controller
@RequestMapping("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> findOne(@RequestParam("email") String email, @RequestParam("pwd1") String password1, @RequestParam("pwd2") String password2, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response)  throws IOException, SQLException{
			 
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		System.out.println(password1+email+username);
		if(password1.length()< 6 || password2.length()< 6) {
			
			return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.BAD_REQUEST);
		}
		else if(!password1.equals(password2)) {
			
			return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.BAD_REQUEST);
			
		}
		else if(username ==null || username.length()<2){
			
			return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.BAD_REQUEST);
		}
		else {
		}
			
		    EmailCheck emailcheck = new EmailCheck();
	
			try {
				if(emailcheck.checkIfEmailExists(email)) {
					
					System.out.println("email exists");
					return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.BAD_REQUEST);
					
                }else {
                	try {
            			
                		Connection con = new InitializeMySqlDb().mySqlDao();
            	
            			PreparedStatement stmt=con.prepareStatement("insert into users(user_email,user_password,user_name) values(?,?,?)");
            			stmt.setString(1,email);  
            			stmt.setString(2,password1);
            			stmt.setString(3,username);
            			int rs=stmt.executeUpdate(); 
            			if(rs==1) {
            				System.out.println("registered");
                        	return new ResponseEntity<String>("{\"status\": \"success\"}", httpHeaders, HttpStatus.OK);
            			}else {
            				System.out.println("email exists");
            				return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.BAD_REQUEST);
            			}
            			
                	}catch(SQLException e) {
                		return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
                	}
                	
                }
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
				return new ResponseEntity<String>("{\"status\": \"failed\"}", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
}


