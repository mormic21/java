import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

/**
 * BaumPythagoras.java zeichnet einen Pythagoras-Baum rekursiv, 
 * mithilfe der Klasse Turtle.java, auf ein JFrame
 * @author Michael Morandell
 * Datum: 06.05.2021
 */
public class BaumPythagoras extends JFrame {
	// Turtle-Objekt
	private Turtle t = null;
	// Konstruktor
	public BaumPythagoras() {
		//Titel wird gesetzt
		setTitle("Baum Pythagoras");
		setBounds(0, 0, 1000, 800);
		setVisible(true);
		// Positionierund der Turtle, wird um 90 Grad nach links gedreht
		t = new Turtle(this, 600, 600, 90);
		// Ereignis: Schließen des Fensters
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	/**
	 * Paint-Methode, welche die rekursive Methode aufruft.
	 * @param Graphics g, die Zeichenfläche
	 */
	public void paint(Graphics g) {
		// Dadurch wird der Hintergrund des Fensters gezeichnet
		super.paint(g);
		// Wenn Turtle exsistiert
		if (t != null) {
			//löschen und neu gesetzt um Darstellungsfehler zu vermeiden
			t.loesche();
			t.setzeRichtung(90);
			//Aufruf
			baum(100, 5, 30);
		} 
		else {
			//Ansonsten versuche Fenster nochmals zu zeichnen
			repaint();
		}
	}
	
	/**
	 * Rekursive baum-Methode, welche den Pythagoras-Baum effektiv zeichnet
	 * @param lc, Länge der Seite c
	 * @param min, Mindeslänge der Seite c (für Abbruch-Bedingung)
	 * @param nwinkel, der Neigungswinkel des Baumes
	 */
	public void baum(double lc, int min, int nwinkel) {
		//Quadrat wird gezeichnet
		for (int i = 0; i < 4; i++) {
			t.vor(lc);
			t.drehe(-90);
		}
		//Abbruchbedingung der Rekursion: die länge von c soll größer als min sein
		if (lc > min) {
			//alle B-Seiten
			t.vor(lc);
			t.drehe(nwinkel);
			baum(Math.cos((Math.PI / 6)) * lc, min, nwinkel);
			//Alle A-Seiten
			t.drehe(90);
			baum(Math.sin((Math.PI / 6)) * lc, min, nwinkel);
			t.drehe(90-nwinkel);
			t.vor(lc);
		}
		//Wenn Abbruch
		else {
			//Turtle ins rechte, untere Eck zurück und zeigt senkrecht nach unten
			t.vor(lc);
			t.drehe(-90);
			t.vor(lc);
			t.drehe(-90);
			t.vor(lc);
		}
	}
}
