package geometrischeFiguren;

public class Quadrat extends Rechteck
{
	public Quadrat(int x, int y, int breite, boolean gefuellt) {
		super(x, y, breite, breite, gefuellt);
	}
	
	/**
	 * Sorgt dafür dass die Höhe gleich groß ist wie die Breite
	 * @param x	x-Koordinate des Objekts
	 * @param y	y-Koordinate des Objekts
	 * @param breite	die Breite und Höhe des Objekts
	 */
	public void setBounds(int x, int y, int breite) {
		super.setBounds(x, y, breite, breite);
	}
	
	/**
	 * Sorgt dafür dass die Höhe auf den Wert der Breite gesetzt wird
	 * @param x	 x-Koordinate des Objekts
	 * @param y	y-Koordinate des Objekts
	 * @param breite	die Breite und Höhe des Objekts
	 * @param hoehe	die hoehe, welche jedoch von der Breite überschrieben wird
	 */
	public void setBounds(int x, int y, int breite, int hoehe) {
		super.setBounds(x, y, breite, breite);
	}
}
