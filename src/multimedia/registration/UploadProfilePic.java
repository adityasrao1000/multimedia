package multimedia.registration;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import custom.exceptions.InvalidContentException;
import multimedia.database.InitializeMySqlDb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;


@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadProfilePic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		java.io.PrintWriter out = response.getWriter();				
		
      
		try {
			
			Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            if(!filePart.getContentType().contains("image")) {
	            	throw new InvalidContentException("The request does not contain an image type.");
	            	
	            }
	        
	        
	        InputStream inputStream = filePart.getInputStream();
	        Connection con = new InitializeMySqlDb().mySqlDao();		
			HttpSession session = request.getSession();
			
			String user_email = (String)session.getAttribute("email");
			PreparedStatement ps=con.prepareStatement("update users set profile_picture=? where user_email=?");     
			 
			ps.setBinaryStream(1,inputStream,inputStream.available());
			ps.setString(2,user_email);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			out.print("success");
			ps.close();
			con.close();
	        }
		}catch(InvalidContentException ex) {
			out.print("failed");
			ex.printStackTrace();
		
		}catch(SQLException ex) {
			out.print("failed");
			ex.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			out.print("failed");
			e.printStackTrace();
		}
	}

}
