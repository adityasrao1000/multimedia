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
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class CompressImage {
	
	private  float IMG_WIDTH = 500;
	private  float IMG_HEIGHT;
	
	
	private BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){

		BufferedImage resizedImage = new BufferedImage((int)IMG_WIDTH, (int)IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, (int)IMG_WIDTH, (int)IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
		RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
	void Compress(OutputStream out,Blob b) throws IOException, SQLException {
		try{
			InputStream os = b.getBinaryStream();
			BufferedImage originalImage = ImageIO.read(os);
			
			IMG_HEIGHT = IMG_WIDTH*((float)originalImage.getHeight()/(float)originalImage.getWidth());
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
			ImageOutputStream ios = ImageIO.createImageOutputStream(out);
			Iterator<ImageWriter> writers =  ImageIO.getImageWritersByFormatName("png");
			ImageWriter writer = (ImageWriter) writers.next();	
		    writer.setOutput(ios);
						
			ImageWriteParam param = writer.getDefaultWriteParam();
			writer.write(null, new IIOImage(resizeImageHintPng, null, null), param);
		    
		    os.close();
		    ios.close();
		    writer.dispose(); 
		}catch(IOException e){
			System.out.println(e.getMessage());
		}		
	}
}


