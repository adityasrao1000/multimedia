package multimedia.session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import multimedia.database.InitializeMySqlDb;


public class GetSessionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		java.io.PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			String email =(String)session.getAttribute("email");
			
			if(email!=null) {
				
				try {
					
					Connection con = new InitializeMySqlDb().mySqlDao();			
					PreparedStatement stmt=con.prepareStatement("select user_name from users where user_email=?");
					stmt.setString(1,email);  
				
					ResultSet rs=stmt.executeQuery(); 
					
					if(rs.next()) {
						String username = rs.getString(1);
						JSONObject obj = new JSONObject();
						obj.put("username", username);
						obj.put("email", email);
			        	out.print(obj);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
