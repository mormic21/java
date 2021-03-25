import java.awt.*;
/**
 * Ball-Klasse für Objekte vom Typ Ball
 * @author Michael Morandell
 *
 */
public class Ball {
	private int radius = 0;
	private int xposition = 60;
	private int yposition = 80;
	private int xrichtung = 0;
	private int yrichtung = 0;
	private java.awt.Color farbe = java.awt.Color.BLACK;

	/**
	 * @return the radius
	 */
	public int getRadius() {
		if (radius < 0)
			return 0;
		else 
			return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return the xposition
	 */
	public int getXposition() {
		return xposition;
	}

	/**
	 * @param xposition the xposition to set
	 */
	public void setXposition(int xposition) {
		if (this.xposition < 0)
			this.xposition = 0;
		else
			this.xposition = xposition;
	}

	/**
	 * @return the yposition
	 */
	public int getYposition() {
		return yposition;
	}

	/**
	 * @param yposition the yposition to set
	 */
	public void setYposition(int yposition) {
		if (this.yposition < 0)
			this.yposition = 0;
		else
			this.yposition = yposition;
	}

	/**
	 * @return the xrichtung
	 */
	public int getXrichtung() {
		return xrichtung;
	}

	/**
	 * @param xrichtung the xrichtung to set
	 */
	public void setXrichtung(int xrichtung) {
		this.xrichtung = xrichtung;
	}

	/**
	 * @return the yrichtung
	 */
	public int getYrichtung() {
		return yrichtung;
	}

	/**
	 * @param yrichtung the yrichtung to set
	 */
	public void setYrichtung(int yrichtung) {
		this.yrichtung = yrichtung;
	}

	/**
	 * @return the farbe
	 */
	public java.awt.Color getFarbe() {
		return farbe;
	}

	/**
	 * @param farbe the farbe to set
	 */
	public void setFarbe(java.awt.Color farbe) {
		this.farbe = farbe;
	}

	/**
	 * toString. Gibt den Inhalt eines Objektes vom Typ Ball, zum ausgeben, zurück.
	 * Beispiel: "r = 10, xpostition = 20, yposition = 70, xrichtung = 10, yrichtung = -5"
	 * @return Inhalt des Ball-Objektes als String
	 */
	public String toString() {
		return "r = " + radius + ", xposition = " + xposition + ", yposition = " + yposition + ", xrichtung = "
				+ xrichtung + ", yrichtung = " + yrichtung;
	}
	
	/**
	 * setZufaellig. Methode welche folgende Eigenschaften des Balles mit zufälligen Werten im angegebenen Bereich füllt:
	 *  - radius, im Bereich 2 bis 40; 
	 *  - xrichtung + yrichtung, im Bereich von -10 und 10. 0 darf dabei nicht vorkommen
	 *  - farbe, zufaellige Farbe im RGB-Bereich zwischen 0 und 255
	 */
	public void setZufaellig() {
		this.radius = (int)(Math.random() * 40) +2;
		do {
			this.xrichtung = (int)(Math.random() * 21) -10;
		} while (this.xrichtung == 0);
		do {
			this.yrichtung = (int)(Math.random() * 21) -10;
		} while (this.yrichtung == 0);
		this.farbe = new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256));
	}
	
	/**
	 * bewege-Methode
	 * Berechnet die neue Position eines Kreises. Erreicht dabei ein Kreis den Rand des Applets, so prallt
	 * er ab. Dabei ist der Ballmittelpunkt immer noch um den Ballradius radius innerhalb des Randes. Wurde 
	 * die neue position und die neue richtung ermittelt so wird der entsprechende Kreis
	 * graphisch, auf der übergebenen Zeichenfläche Graphics g, ausgegeben.
	 * @param g, die Zeichenfläche des Applets, zur graphischen Ausgabe
	 * @param width, breite des Applets, als double
	 * @param height, höhe des Applets, als double
	 */
	public void bewege(Graphics g, double width, double height) {
		//newxpos variable, hilfsvariable für berechnungen auf der X-Koordinate
		int newxpos = this.xposition + this.xrichtung;
		//Wenn am linken rand
		if(newxpos < 8) {
			newxpos = 8;
			this.xrichtung *= -1;
		}
		//Wenn am rechten Rand
		if (newxpos + (this.radius*2) > width-8) {
			newxpos = (int)width - this.radius*2-8;
			this.xrichtung *= -1;
		}
		//newypos variable, hilfsvariable für berechnungen auf der y-Koordinate
		int newypos = this.yposition + this.yrichtung;
		//Wenn am oberen Rand - 33px Abstand wegen Jframe Titel-Balken
		if(newypos < 33) {
			newypos = 33;
			this.yrichtung *= -1;
		}
		//Wenn am unteren Rand
		if (newypos + (this.radius*2) > height-8) {
			newypos = (int)(height - this.radius*2) -8;
			this.yrichtung *= -1;
		}
		//Neue werte werden in die Membervariablen übertragen
		this.xposition = newxpos;
		this.yposition = newypos;
		//Kreis wird gezeichnet
		g.setColor(this.farbe);
		g.fillOval(this.xposition, this.yposition, this.radius*2, this.radius*2);
	}
	
	
}
