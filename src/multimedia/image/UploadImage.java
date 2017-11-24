package multimedia.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();  
		String driverName = context.getInitParameter("databaseURL");  
		String dbusername = context.getInitParameter("databaseUserName");
		String dbpassword = context.getInitParameter("databasePassword");
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(driverName,dbusername,dbpassword);  			
			HttpSession session = request.getSession();
			
			String user_email = (String)session.getAttribute("email");
			PreparedStatement ps=con.prepareStatement("insert into imagetable values(?,?,?)");  
			ps.setString(1,user_email);  
			ps.setString(2,"b"); 
			FileInputStream fin=new FileInputStream("C:\\Users\\Aditya rao\\Pictures\\img\\a.jpg");  
			ps.setBinaryStream(3,fin,fin.available());  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			          
			con.close();  
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
