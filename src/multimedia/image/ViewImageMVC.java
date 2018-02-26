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
				PreparedStatement ps=con.prepareStatement("select id from imagetable where id=?");  
				ps.setString(1,id);  
			
				ResultSet rs=ps.executeQuery();  
				model.addAttribute("id", id);
				if(rs.next()) {   
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
