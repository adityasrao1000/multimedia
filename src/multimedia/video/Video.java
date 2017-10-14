package multimedia.video;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;


@WebServlet("/Video")
public class Video extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();	
		
		response.addHeader("Content-Type", "video/mp4");
		response.addHeader("Transfer-Encoding", "chunked");
		out.print(encodeFileToBase64Binary("C:\\Users\\Aditya rao\\Pictures\\Saved Pictures\\Anime mix 10 seconds.mp4"));
		
	}
	
	
	String encodeFileToBase64Binary(String fileName) throws IOException {

		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.getEncoder().encode(bytes);;
		String encodedString = new String(encoded);

		return encodedString;
	}


	 byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	    	is.close();
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
}
	
}
