package multimedia.image;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import custom.exceptions.InvalidContentException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import java.time.LocalDate;
import java.time.LocalDateTime;


@WebServlet("/UploadImage")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		ServletContext context = getServletContext();  
		String driverName = context.getInitParameter("databaseURL");  
		String dbusername = context.getInitParameter("databaseUserName");
		String dbpassword = context.getInitParameter("databasePassword");
		
		 LocalDateTime currentTime = LocalDateTime.now();
		 LocalDate date = currentTime.toLocalDate();
		try {
			
			String fileName;
			Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            fileName = request.getParameter("name");
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            if(!filePart.getContentType().contains("image")) {
	            	throw new InvalidContentException("The request does not contain an image type.");
	            	
	            }
	            // obtains input stream of the upload file
	            
	        
	        InputStream inputStream = filePart.getInputStream();
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(driverName,dbusername,dbpassword);  			
			HttpSession session = request.getSession();
			
			String user_email = (String)session.getAttribute("email");
			PreparedStatement ps=con.prepareStatement("insert into imagetable(user_email,photo_name,photo,upload_date) values(?,?,?,?)");  
			ps.setString(1,user_email);  
			ps.setString(2,fileName); 
			 
			ps.setBinaryStream(3,inputStream,inputStream.available()); 
			ps.setDate(4,java.sql.Date.valueOf(date));
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			          
			con.close();
	        }
		}catch(InvalidContentException ex) {
			ex.printStackTrace();
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
