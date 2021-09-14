package geometrischeFiguren;

import java.awt.*; // Graphics

public class Rechteck extends Punkt
{
	protected boolean gefuellt;
	

	public Rechteck(int x, int y, int breite, int hoehe, boolean gefuellt) {
		setBounds(x, y, breite, hoehe);
		this.gefuellt = gefuellt;
	}
	
	/**
	 * zeichnet das Rechteck
	 */
	public void paint(Graphics g) {
		g.setColor(this.farbe);
		if(this.gefuellt == true) {
			g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}else {
			g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}

	}
	

	/**
	 * @return the gefuellt
	 */
	public boolean isGefuellt() {
		return gefuellt;
	}

	/**
	 * @param gefuellt the gefuellt to set
	 */
	public void setGefuellt(boolean gefuellt) {
		this.gefuellt = gefuellt;
	}
}
