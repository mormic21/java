import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 * RekursiveFiguren.java, zeichnet ein paar geometrische Figruen rekursiv,
 * mithilfe der Turtle.java auf einen JFrame
 * @author Michael Morandell
 * Date: 06.05.2021
 */
public class RekursiveFiguren extends JFrame{
	//Turtle-Objekt
	private Turtle t = null;
	//Konstruktor
	public RekursiveFiguren() {
		setTitle("Rekursive Figuren");
		setBounds(0,0,800,800);
		setVisible(true);
		// Positionierung der Turtle
		t = new Turtle(this,400,400,90);
		// Ereignis: Schließen des Fensters
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					setVisible(false);
					dispose();
					System.exit(0);
				}
			}
		);
	}
	
	/**
	 * paint-Methode
	 * ruft die einzelnen rekursiven Programme auf, welche die Figuren auf dem JFrame zeichnen
	 * @param Graphics g, die Zeichenfläche des JFrames
	 */
	public void paint(Graphics g) {
		// Dadurch wird der Hintergrund des Fensters gezeichnet
		super.paint(g);
		//Wenn Turtle exsistiert
		if (t != null) {
			t.loesche();
			t.setzeKOS(0, getWidth(), 0, getHeight());
			t.stiftHoch();
			t.geheZu(200, 600);
			t.stiftRunter();
			//Quadrate ineinander werden gezeichnet
			quadrat(10);
			t.stiftHoch();
			t.geheZu(600, 600);
			t.stiftRunter();
			//Kreise ineinander werden gezeichnet
			kreis(5);
			t.stiftHoch();
			t.geheZu(710, 400);
			t.stiftRunter();
			t.setzeRichtung(180);
			//Quadrate nebeneinander
			quadrate(60);
			t.stiftHoch();
			t.geheZu(650, 180);
			t.stiftRunter();
			//Kreise nebeneinander werden gezeichnet
			kreise(100);
		}
		else {
			// Wenn turtle null ist...
			repaint();
		}
	}
	
	/**
	 * Methode Quadrat. Zeichnet rekursiv, Quadrate ineinander
	 * @param length, die Länge des kleinsten Quadrates in der Mitte
	 */
	public void quadrat(int length) {
		//Quadrat wird gezeichnet
		for (int i = 0; i < 4; i++) {
			t.vor(length);
			t.drehe(-90);
		}
		//Turtle geht in die Mitte
		t.drehe(180);
		t.stiftHoch();
		t.vor(3);
		t.drehe(-90);
		t.vor(3);
		t.drehe(-90);
		t.stiftRunter();
		//Abbruchbedingung: Länge soll max. 1/3 der Breite des JFrame sein
		if (length < getWidth()/3) {
			//rekursiver aufruf, länge wird um 6 erhöht
			quadrat(length+6);
		}
	}
	
	/**
	 * Kreis-Methode, zeichnet, rekursiv, Kreise ineinander
	 * @param radius
	 */
	public void kreis(int radius) {
		//anzahl der ecken des n-ecks (um Kreis zu erhalten)
		double n = 13140.0;
		//Parameter für Kreis
		double winkel = 360.0/n;
		double l = 2.0 * radius * Math.sin(winkel/2*Math.PI/180);
		//zu einem fixen Punkt (mitte der rekursiven Figur)
		t.stiftHoch();
		t.geheZu(600, 600);
		//geht zum Start des Kreises
		t.vor(radius);
		t.drehe(90+winkel/2.0);
		t.stiftRunter();
		//Kreis wird gezeichnet
		for (int i = 0; i < n; i++) {
			t.vor(l);
			t.drehe(winkel);
		}
		//radius soll max. 1/6tel des Jframes sein
		if (radius < getWidth()/6) {
			//rekursiver Aufruf, radius wird dabei um 4 erhöht
			kreis(radius+4);
		}
	}
	
	/**
	 * Quadrate-Methode
	 * Zeichnet Quadrate nebeneinander rekursiv
	 * @param l, die Seitenlänge des kleinsten Quadrates
	 */
	public void quadrate(int l) {
		//Quadrat wird gezeichnet
		for (int i = 0; i < 4; i++) {
			t.vor(l);
			t.drehe(90);
		}
		//Springe zum Punkt wo das neue Quadrat gezeichnet wird
		t.stiftHoch();
		t.vor(l+5);
		t.stiftRunter();
		//Abbruchbdingung: wenn in der Breite kein Quadrat mehr Platz hat
		if (t.aktuellesX()- (l+8) > 40) {
			//rekursiver Aufruf, l wird um 8 erhöht
			quadrate(l+8);
		}
	}
	
	/**
	 * Kreise-Methode, welche Kreise nebeneinander, rekursiv zeichnet
	 * @param radius, der Radius der Kreise
	 */
	public void kreise (int radius) {
		//anzahl der ecken des n-eckes
		double n = 13140.0;
		//parameter für den Kreis
		double winkel = 360.0/n;
		double l = 2.0 * radius * Math.sin(winkel/2*Math.PI/180);
		//springe zum Startpunkt, ab wo der Kreis gezeichnet wird
		t.stiftHoch();
		t.geheZu(t.aktuellesX()-8, 150);
		t.setzeRichtung(90);
		t.vor(radius);
		t.drehe(90+winkel/2.0);
		t.stiftRunter();
		//Kreis wird gezeichnet
		for (int i = 0; i < n; i++) {
			t.vor(l);
			t.drehe(winkel);
		}
		//Abbruchbedingung: wenn in der Breite kein Kreis mehr Platz hat
		if ((t.aktuellesX()-radius) > 40) {
			//rekursiver Aufruf
			kreise(radius);
		}
    }
}
