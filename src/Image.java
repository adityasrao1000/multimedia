import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.simple.JSONArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();	
		response.addHeader("content-type" ,"application/json");
		List<String> filelist = getFile("C:\\Users\\aditya\\Pictures\\img");
		JSONArray list = new JSONArray();
		for(String s:filelist){  
			 list.add(encodeFileToBase64Binary(s));
		}  
	
		out.print(list);
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
    //method to retrieve all the images in folder
	private List<String> getFile(String dirPath) {
	    File f = new File(dirPath);
	    File[] files = f.listFiles();
        int count = 0;
        List<String> arr = new ArrayList<String>();
	    if (files != null)
	    for (int i = 0; i < files.length; i++) {
	    	
	        count++;
	      arr.add(files[i].toString().replace("\\", "\\\\"));
	        
	    }
	    
	    System.out.println("number of records in file: "+ count);
	    return arr;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
