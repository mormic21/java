import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 * RekursiveKreise.java, Zeichnet auf ein JFrame, mithilfe dessen Funktionen,
 * eine Figur, bestehend aus rekursiven Kreisen
 * @author Michael Morandell 
 * Datum: 06.05.2021
 */
public class RekursiveKreise extends JFrame {
	// Konstruktor
	public RekursiveKreise() {
		// Titel wird gesetzt
		setTitle("Rekursive Figuren");
		setBounds(0, 0, 800, 800);
		setVisible(true);
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
	 * Paint-Methode, ruft die rekursive Methode auf
	 * @param Graphics g, die Zeichenfläche
	 */
	public void paint(Graphics g) {
		super.paint(g);
		//aufruf
		kreise(g, 220, 220, 360);
	}

	/**
	 * Rekursive Methode für rekursive Figur, bestehend aus Kreisen
	 * @param g, Zeichenfläche
	 * @param x, die x-Koordinate des Kreises
	 * @param y, die Y-Koordinate des Kreises
	 * @param radius, der Radius des Kreises
	 */
	public void kreise(Graphics g, int x, int y, int radius) {
		// Kreis wird gezeichnet
		g.drawOval(x, y + 10, radius, radius);
		// Rekursive Wiederholung, solange der ursprüngliche radius max 5 mal halbiert wird
		if (radius > 360 / Math.pow(2, 5)) {
			//Kleinere Kreise auf allen 4tel des größeren Kreises wird gezeichnet
			kreise(g, x + radius / 4, y - radius / 4, radius / 2);
			kreise(g, x - radius / 4, y + radius / 4, radius / 2);
			kreise(g, x + radius - radius / 4, y + radius / 4, radius / 2);
			kreise(g, x + radius / 4, y + radius - radius / 4, radius / 2);
		}

	}
}
