package multimedia.login;

import java.sql.*; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import multimedia.database.InitializeMySqlDb;

@WebServlet("/loginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		try {
			java.io.PrintWriter out = response.getWriter();
			InitializeMySqlDb db =new InitializeMySqlDb();
	    	Connection con = db.mySqlDao(); 
	
			PreparedStatement ps=con.prepareStatement("select * from users where user_email=? and user_password=?");
			ps.setString(1,email);  
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery(); 
			
			if(rs.next()) {
				
				HttpSession session=request.getSession(true);  
		        session.setAttribute("email",email); 
		        out.print("valid");   
		        
			}else {
					
			    out.print("invalid");  
			 			
			}
			db.close(ps, rs, con);
		}
		catch(SQLException e) {			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
