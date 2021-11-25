package net.tfobz.vokabeltrainer.guis;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Shows an image in a JComponent. ImageComponent can be integrated
 * in a JFrame like any other component. The image will be automatically scaled 
 * to the dimension of the component
 * @author Michael Wild
 */
public class ImageComponent extends JComponent
{
	private BufferedImage image = null;
	
	public void setImage(String fileName) throws IOException {
		File file = new File(fileName);
		setImage(file);
	}
	
	public void setImage(File file) throws IOException {
		if ((image = ImageIO.read(file)) != null) {
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (image != null) {
			g.drawImage(image,  0, 0, this.getWidth(), this.getHeight(), null);
		}
	}
}

