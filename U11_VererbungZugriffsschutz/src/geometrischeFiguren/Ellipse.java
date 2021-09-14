package geometrischeFiguren;

import java.awt.Graphics;

public class Ellipse extends Rechteck
{
	public Ellipse(int x, int y, int width, int height, boolean gefuellt) {
		super(x, y, width, height, gefuellt);
	}
	
	/**
	 * zeichnet die Ellypse
	 */
	public void paint(Graphics g) {
		g.setColor(this.farbe);
		if(this.gefuellt == true) {
			g.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}else {
			g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}
	}
}
