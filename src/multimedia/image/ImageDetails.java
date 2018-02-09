package multimedia.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

public class ImageDetails {
	
	void printDetails(Part f) throws IOException {
		
		 System.out.println(f.getName());
         System.out.println(f.getSize());
         System.out.println(f.getContentType());
         
         BufferedImage img = ImageIO.read(f.getInputStream());
         int width          = img.getWidth();
         int height         = img.getHeight();
         System.out.println("dimensions: "+width+"x"+height);
         img.flush();
	}
}
