package multimedia.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletContext context = getServletContext();  
		String driverName = context.getInitParameter("databaseURL");  
		String dbusername = context.getInitParameter("databaseUserName");
		String dbpassword = context.getInitParameter("databasePassword");   
	 
		java.io.PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		response.setContentType("application/json");
		String password1 = request.getParameter("pwd1");
		String password2 = request.getParameter("pwd2");

		if(password1.length()< 6 || password2.length()< 6) {
			
			out.print("{\"status\": \"failed\"}");
		}
		else if(!password1.equals(password2)) {
			
			out.print("{\"status\": \"failed\"}");
			
		}else {
			
		    EmailCheck emailcheck = new EmailCheck();
	
			try {
				if(emailcheck.checkIfEmailExists(email)) {
					
					System.out.println("email exists");
					out.print("{\"status\": \"failed\"}");
					
                }else {
                	try {
            			
            			Class.forName("com.mysql.jdbc.Driver");  
            			Connection con=DriverManager.getConnection(driverName,dbusername,dbpassword);  
            	
            			PreparedStatement stmt=con.prepareStatement("insert into users(user_email,user_password) values(?,?)");
            			stmt.setString(1,email);  
            			stmt.setString(2,password1);
            			int rs=stmt.executeUpdate(); 
            			if(rs==1) {
            				System.out.println("registered");
                        	out.print("{\"status\": \"success\"}");
            			}else {
            				System.out.println("email exists");
        					out.print("{\"status\": \"failed\"}");
            			}
            			
                	}catch(SQLException e) {
                		
                	}
                	
                }
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				
			} 
		}
	}

}
