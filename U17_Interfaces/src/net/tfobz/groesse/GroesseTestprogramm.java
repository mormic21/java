package net.tfobz.groesse;

/**
 * GroesseTestprogramm
 * @author Michael Morandell
 *
 */
public class GroesseTestprogramm {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//Groesse-Array
		Groesse [] g = new Groesse[8];
		//Elemente werden ins Array gesetzt
		g[0] = new Auto(20,20,50);
		g[1] = new Auto(200, 100, 80);
		g[2] = new Fussballfeld();
		g[3] = new Papierblatt(0);
		g[4] = new Papierblatt(1);
		g[5] = new Papierblatt(2);
		g[6] = new Papierblatt(3);
		g[7] = new Papierblatt(4);
		//Ausgabe der Elemente
		for (Groesse gr : g) {
			System.out.println(gr.toString());
		}
	}
}