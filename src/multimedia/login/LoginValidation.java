package multimedia.login;
import java.sql.*; 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		ServletContext context = getServletContext();  
		String driverName = context.getInitParameter("databaseURL");  
		String dbusername = context.getInitParameter("databaseUserName");
		String dbpassword = context.getInitParameter("databasePassword");
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(driverName,dbusername,dbpassword);  

		PreparedStatement stmt=con.prepareStatement("select * from users where user_email=? and user_password=?");
		stmt.setString(1,email);  
		stmt.setString(2,password);
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()) {
			
			HttpSession session=request.getSession(true);  
	        session.setAttribute("email",email); 
	        response.sendRedirect("home");
	        
		}else {
			
			RequestDispatcher rd=request.getRequestDispatcher("login");  
			request.setAttribute("status","The username or password is invalid");
			rd.forward(request, response);
			
		}
		con.close();
		}catch(SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
	}



}
