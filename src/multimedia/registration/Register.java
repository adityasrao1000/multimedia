package multimedia.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
                	System.out.println("registered");
                	out.print("{\"status\": \"success\"}");
                }
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				
			} 
		}
	}

}
