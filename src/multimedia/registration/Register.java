package multimedia.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import multimedia.database.InitializeMySqlDb;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	 
		java.io.PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		response.setContentType("application/json");
		
		String password1 = request.getParameter("pwd1");
		String password2 = request.getParameter("pwd2");
		String username = request.getParameter("username");
		
		if(password1.length()< 6 || password2.length()< 6) {
			
			out.print("{\"status\": \"failed\"}");
		}
		else if(!password1.equals(password2)) {
			
			out.print("{\"status\": \"failed\"}");
			
		}else if(username ==null || username.length()<2){
			out.print("{\"status\": \"failed\"}");
		}
		else {
		}
			
		    EmailCheck emailcheck = new EmailCheck();
	
			try {
				if(emailcheck.checkIfEmailExists(email)) {
					
					System.out.println("email exists");
					out.print("{\"status\": \"failed\"}");
					
                }else {
                	try {
            			
                		Connection con = new InitializeMySqlDb().mySqlDao();
            	
            			PreparedStatement stmt=con.prepareStatement("insert into users(user_email,user_password,user_name) values(?,?,?)");
            			stmt.setString(1,email);  
            			stmt.setString(2,password1);
            			stmt.setString(3,username);
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


