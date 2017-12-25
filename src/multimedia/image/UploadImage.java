package multimedia.image;

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
import org.json.simple.parser.ParseException;
import javax.servlet.annotation.MultipartConfig;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;


@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 java.io.PrintWriter out = response.getWriter();				
				
		 LocalDateTime currentTime = LocalDateTime.now();
		 LocalDate date = currentTime.toLocalDate();
		try {
			
			String fileName;
			String tags;
			Part filePart = request.getPart("photo");
	        if (filePart != null) {
	        	
	            // prints out some information for debugging
	            fileName = request.getParameter("name");
	            tags = request.getParameter("tags");
	            System.out.println(tags);
	            ImageDetails img = new ImageDetails();
	            img.printDetails(filePart);
	            
	            if(!filePart.getContentType().contains("image")) {
	            	throw new InvalidContentException("The request does not contain an image type.");
	            	
	            }
	        // obtains input stream of the upload file
	        InputStream inputStream = filePart.getInputStream();
	        Connection con = new InitializeMySqlDb().mySqlDao();		
			HttpSession session = request.getSession();
			
			//parse and extract tags
			TagParse tp =  new TagParse();
			String[] tagarr = tp.extract(tags);
			Arrays.stream(tagarr).forEach(tag -> System.out.println(tag));
			
			String user_email = (String)session.getAttribute("email");
			PreparedStatement ps=con.prepareStatement("insert into imagetable(user_email,photo_name,photo,upload_date) values(?,?,?,?)");  
			ps.setString(1,user_email);  
			ps.setString(2,fileName); 
			 
			ps.setBinaryStream(3,inputStream,inputStream.available()); 
			ps.setDate(4,java.sql.Date.valueOf(date));
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
		} catch (ParseException e) {
			out.print("failed");
			e.printStackTrace();
		}
	}
}
