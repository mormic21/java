import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;

/**
 * RekursiverBaum, zeichnet rekursiv einen Baum mit �sten auf ein JFrame, mithilfe von Turtle.java
 * @author Michael Morandell
 * Datum: 06.05.2021
 */
public class RekursiverBaum extends JFrame {
	// Turtle-Objekt
	private Turtle t = null;
	// Konstruktor
	public RekursiverBaum() {
		//Titel wird gesetzt
		setTitle("Rekursiver Baum");
		setBounds(0, 0, 1000, 900);
		setVisible(true);
		// Positionierung der Turtle
		t = new Turtle(this, 500, 870, 90);
		// Ereignis: Schlie�en des Fensters
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	/**
	 * Paint-Methode, ruft die rekursive baum()-Methode auf
	 * @param Graphics g, die Zeichenfl�che
	 */
	public void paint(Graphics g) {
		super.paint(g);
		// Wenn Turtle exsistiert
		if (t != null) {
			//l�schen und neu-setzen, um Darstellungsfehler zu umgehen
			t.loesche();
			t.setzeRichtung(90);
			//Aufruf
			baum(200, 0, 15);
		} 
		//Wenn Turtle null ist
		else {
			repaint();
		}
	}
	
	/**
	 * Baum-Methode, welche Rekursiv den Baum zeichnet
	 * @param length, die L�nge des Stammes (erster Ast)
	 * @param winkel der �ste
	 * @param anzahl der Unter-�ste
	 */
	public void baum(double length, double winkel, int anzahl) {
		//Abbruch-Bedingung: wenn Anzahl der Unter�ste erreicht wurden
		if (anzahl >= 0) {
			//rechter Hauptast wird gezeichnet und dessen unter�ste
			t.drehe(winkel);
			t.vor(length);
			//rekursiver Aufruf, Unter-�ste sind um 0,75 kleiner, �ste nach links
			baum(length * 0.75, 30, anzahl - 1);
			//geht vom letzten Unterast richtung Stamm zur�ck
			t.drehe(180);
			t.vor(length);
			t.drehe(180 - winkel);
			t.drehe(winkel);
			t.vor(length);
			//Rekursion, f�r rechte Unter�ste
			baum(length * 0.75, -30, anzahl - 1);
			t.drehe(180);
			t.vor(length);
			t.drehe(180 - winkel);
		}
	}
}
