package multimedia.registration;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resetpassword")
public class ResetPassword{
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> findOne(@RequestParam("otp") String otp, @RequestParam("pwd1") String password1, HttpServletRequest request, HttpServletResponse response)  throws IOException, SQLException{
			 
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return null;
		
		}
}



