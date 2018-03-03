package multimedia.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import multimedia.database.InitializeMySqlDb;


@Controller
@RequestMapping("/passwordChangeOtp")
public class OtpPasswordMVC {

	
	@RequestMapping(method = RequestMethod.GET)
	public String ModelAndView(@RequestParam("email") String email,@RequestParam("token") String token,ModelMap model) throws IOException, SQLException{
		      	
	    try {
	    	InitializeMySqlDb db = new InitializeMySqlDb();
	    	Connection con = db.mySqlDao();
			PreparedStatement ps=con.prepareStatement("select token,user_email from resetpassword where user_email=? and token=?");  
			ps.setString(1,email);  
			ps.setString(2,token);
			
			ResultSet rs=ps.executeQuery();  
			if(rs.next()) { 
				
				model.addAttribute("email", email);
				
				db.close(ps, rs, con);
				return "login";
			}else {
				db.close(ps, rs, con); 
				return "404";
			}
		  
				
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return "404";
		    }		    
	  }
}

