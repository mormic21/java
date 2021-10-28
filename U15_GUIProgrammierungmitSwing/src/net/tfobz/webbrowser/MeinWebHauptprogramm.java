package net.tfobz.webbrowser;

/**
 * MeinWebHauptprogramm
 * Instanziiert ein GUI-Objekt vom Typ MeinWeb.java und macht es visible
 * @author Michael Morandell
 *
 */
public class MeinWebHauptprogramm {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//MeinWeb-GUI
		MeinWeb m = new MeinWeb();
		//Visible
		m.setVisible(true);
	}

}
