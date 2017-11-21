package multimedia.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/image")
@Produces("image/png")
public class DisplayImage {
	@Context
    HttpServletResponse response;
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String path) throws IOException{
		
		    ServletOutputStream out;  
		    out = response.getOutputStream();  
		    
		    try {
		    File file = new File("C:\\Users\\Aditya rao\\Pictures\\Saved Pictures\\" + path);
		    FileInputStream fin = new FileInputStream(file);  
		      
		    BufferedInputStream bin = new BufferedInputStream(fin);  
		    BufferedOutputStream bout = new BufferedOutputStream(out);  
		    int ch =0; ;  
		    while((ch=bin.read())!=-1)  
		    {  
		    bout.write(ch);  
		    }  

		    bin.close();  
		    fin.close();  
		    bout.close();  
		    out.close();  
		    
		    }catch(FileNotFoundException e) {
		    	
		    	return  Response.status(404).build();
		    }
		    
          return  Response.status(200).build();
	  }    
	
        
		
}
	
