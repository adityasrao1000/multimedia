package multimedia.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CompressImage {
	
	void Compress(OutputStream out,float quality,Blob b) throws IOException, SQLException {
		
		InputStream os = b.getBinaryStream();
		BufferedImage image = ImageIO.read(os);
		Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
	    ImageWriter writer = (ImageWriter) writers.next();
	
	    ImageOutputStream ios = ImageIO.createImageOutputStream(out);
	    writer.setOutput(ios);
	
	    ImageWriteParam param = writer.getDefaultWriteParam();
	    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	    param.setCompressionQuality(quality);
	    writer.write(null, new IIOImage(image, null, null), param);
	    
	    
	    os.close();
	    ios.close();
	    writer.dispose(); 
	}
}
