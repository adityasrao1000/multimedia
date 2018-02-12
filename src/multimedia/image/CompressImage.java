package multimedia.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class CompressImage {
	
	private  float IMG_WIDTH;
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
	void Compress(OutputStream out, int width, Blob b) throws IOException, SQLException {
		try{
			IMG_WIDTH=width;
			InputStream os = b.getBinaryStream();
			BufferedImage originalImage = ImageIO.read(os);
			
			IMG_HEIGHT = IMG_WIDTH*((float)originalImage.getHeight()/(float)originalImage.getWidth());
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizedImage = resizeImageWithHint(originalImage, type);
		    ImageIO.write(resizedImage, "png", out); 
		    
		}catch(IOException e){
			System.out.println(e.getMessage());
		}		
	}
}


