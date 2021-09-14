package geometrischeFiguren;

import javax.swing.*; // JComponent
import java.awt.*; // Color, Graphics

public class Punkt extends JComponent
{
	private static final int PUNKT_GROESSE = 8;
	protected Color farbe = Color.BLACK;

	// Defaultkonstruktor
	public Punkt() {
	}

	public Punkt(int x, int y) {
		setBounds(x, y, PUNKT_GROESSE, PUNKT_GROESSE);
	}
	
	/**
	 * Setzt die Farbe des Objekts
	 * @param farbe	die Farbe des Objekts
	 */
	public void setFarbe(Color farbe) {
		this.farbe = farbe;
		repaint();
	}
	
	/**
	 * @return	die Farbe des Objekts
	 */
	public Color getFarbe() {
		return this.farbe;
	}
	
	/**
	 * zeichnet den Punkt
	 */
	public void paint(Graphics g) {
		g.setColor(this.farbe);
		g.fillOval(0, 0, PUNKT_GROESSE, PUNKT_GROESSE);
	}
}