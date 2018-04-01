package multimedia.image;

import java.io.IOException;
import multimedia.database.InitializeMySqlDb;
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
import java.sql.*;

@Controller
@RequestMapping("/deleteTag")
public class RemoveTag {
	
	
	@RequestMapping(value = "/{image_id}/{tag}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> findOne(@PathVariable("image_id") String id,@PathVariable("tag") String tag, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
			
	    	HttpSession session = request.getSession();
	    	String email = (String)session.getAttribute("email");
	    	
		    try {
               
		    	InitializeMySqlDb db =new InitializeMySqlDb();
		    	Connection con = db.mySqlDao();
		    	PreparedStatement ps=con.prepareStatement("select count(*) from tags where id=?");  
		    	ps.setString(1,id);
		    	ResultSet rs = ps.executeQuery();
		    	if(rs.next()) {
		    	if(rs.getInt(1)>1) {
				ps=con.prepareStatement("delete  from tags  where id=? and tag=? and ?=(select user_email from imagetable where id=?)");  
				ps.setString(1,id);  
				ps.setString(2,tag);
				ps.setString(3,email); 
				ps.setString(4,id); 
				int i=ps.executeUpdate();  
		
				db.close(ps, rs, con);
				if(i>1) {
				 System.out.println("more than 1 tag affected");
				}
				System.out.println(i+ " tag deleted");
				return new ResponseEntity<String>("success", HttpStatus.OK);
		    	}
		    	}
		    	db.close(ps, rs, con);
		    	return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
		    
	  }    
	
        
		
}
	
