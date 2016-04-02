package desagil.vision;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.coobird.thumbnailator.Thumbnails;

public class Image {
	
	public static BufferedImage makeImage(String imageLocal) throws IOException {
		BufferedImage image = ImageIO.read(new File(imageLocal));
		return image;
	}
	
	public static JLabel bufferedImageToJLabel(BufferedImage image) {
		JLabel labeledImage = new JLabel(new ImageIcon(image));
		return labeledImage;
	}
	
	public static BufferedImage resizeBufferedImage(BufferedImage image, int newWidth, int newHeight) throws IOException {
		return Thumbnails.of(image).size(newWidth, newHeight).asBufferedImage();
	}

}