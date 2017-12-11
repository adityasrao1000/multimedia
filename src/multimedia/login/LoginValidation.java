package multimedia.login;
import java.sql.*; 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			
			Connection con = new InitializeMySqlDb().mySqlDao();
	
			PreparedStatement stmt=con.prepareStatement("select * from users where user_email=? and user_password=?");
			stmt.setString(1,email);  
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery(); 
			
			if(rs.next()) {
				
				HttpSession session=request.getSession(true);  
		        session.setAttribute("email",email); 
		        response.sendRedirect("home");  
		        
			}else {
				 request.setAttribute("status", "Your email or password is incorrect");		
				 RequestDispatcher rd=request.getRequestDispatcher("login");  
			     rd.forward(request, response);//method may be include or forward  
				
			}
			stmt.close();
			con.close();
		}catch(SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
