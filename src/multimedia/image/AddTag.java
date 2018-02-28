package multimedia.image;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import multimedia.database.InitializeMySqlDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@Controller
@RequestMapping("/addTag")
public class AddTag {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findOne(@PathVariable("id") String id, @RequestParam("tag") String tag, HttpServletRequest request, HttpServletResponse response)  throws  SQLException{
	
	    	HttpSession session = request.getSession();
	     	String email = (String)session.getAttribute("email");
		    try {
		    	InitializeMySqlDb db = new InitializeMySqlDb();
		    	Connection con = db.mySqlDao();
	
				PreparedStatement ps=con.prepareStatement("SELECT count(t.id), i.user_email from tags t INNER JOIN imagetable i ON t.id=i.id where t.id=?");  
				ps.setString(1,id);  
				ResultSet rs = ps.executeQuery(); 
				
				if(rs.next()) {
				
					if(rs.getInt(1)<10 && rs.getString(2).equals(email)) {
							
							tag = tag.trim().toLowerCase();
							tag = tag.replaceAll("\\s"," "); 
							
							if(tag.length()>30 && tag.length()>=2) {
								return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
							}
							
							ps=con.prepareStatement("insert into tags(id,tag,upload_date) values(?,?,(select upload_date from imagetable where id=?))");
							ps.setString(1, id);
							ps.setString(2, tag);
							ps.setString(3, id);
							int i = ps.executeUpdate();
							
							//if one row updated then tag has been successfully inserted into the database					
							if(i==1) {
								System.out.println(i+" tag added");
								db .close(ps,rs,con);
								return new ResponseEntity<String>("success", HttpStatus.OK);
							}						
						
						}
						
					}
				
				
				db .close(ps,rs,con);
				return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>("failed", HttpStatus.NOT_FOUND);
		    }
	  }    
}
	
