package multimedia.image;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import multimedia.database.InitializeMySqlDb;


@Controller
@RequestMapping("/viewimage")
public class ViewImageMVC {
	

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String ModelAndView(@PathVariable("id") String id,ModelMap model) throws IOException, SQLException{
		      	
	    try {
	    	InitializeMySqlDb db = new InitializeMySqlDb();
	    	Connection con = db.mySqlDao();
			PreparedStatement ps=con.prepareStatement("select i.id, u.user_name,i.user_email from imagetable i, users u where i.id=? and i.user_email=u.user_email");  
			ps.setString(1,id);  
		
			ResultSet rs=ps.executeQuery();  
			if(rs.next()) {   
				model.addAttribute("id", id);
				model.addAttribute("username", rs.getString(2));
				model.addAttribute("email", rs.getString(3));
				db.close(ps, rs, con);
				return "imagedetails";
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
