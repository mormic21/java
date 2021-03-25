import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse CosSinFenster mit Konstruktor für GUI und Koordinatensystem, Sinus und Cosinus werden auf der GUI gezeichnet
 * @author Michael Morandell
 *
 */
public class CosSinFenster extends JFrame {
	private final double WELT_X0 = -10.0;
	private final double WELT_Y0 = -1.0;
	private final double WELT_X1 = 10.0;
	private final double WELT_Y1 = 1.0;
	
	/**
	 * Default-Konstruktor.
	 * Setzt Titel, Höhe und Breite, CloseOperation, Sichtbarkeit und ob die Größe verändert werden kann (resizable)
	 */
	public CosSinFenster() {
		setTitle("Cosinus-, Sinusberechnung");
		setBounds(10, 10, 600, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
	}
	
	/**
	 * Umwandlung Welt-X-Koordinaten in Bildschirmkoordinaten. Da die Methoden
	 * getHeight und getWidth auch die Ränder und insbesondere die Titelleiste in die
	 * Höhe und Breite des Fensters einrechnen, müssen mit Insets diese Ränder
	 * weggezählt werden
	 * @param xwert die umzuwandelnde Welt-X-Koordinate
	 * @return die Bildschirmkoordinate
	 */
	private int umrechnungX(double xwert) {
		Insets i = getInsets();
		return i.left + (int) ((xwert - WELT_X0) * (getWidth() - i.left - i.right) / (WELT_X1 - WELT_X0));
	}
	
	/**
	 * Umwandlung Welt-Y-Koordinaten in Bildschirmkoordinaten. Da die Methoden
	 * getHeight und getWidth auch die Ränder und insbesondere die Titelleiste in die
	 * Höhe und Breite des Fensters einrechnen, müssen mit Insets diese Ränder
	 * weggezählt werden
	 * @param ywert die umzuwandelnde Welt-Y-Koordinate
	 * @return die Bildschirmkoordinate
	 */
	private int umrechnungY(double ywert) {
		Insets i = getInsets();
		return i.top + (int) (getHeight() - i.top - i.bottom
				- (ywert - WELT_Y0) * (getHeight() - i.top - i.bottom) / (WELT_Y1 - WELT_Y0));
	}
	
	/**
	 * Paint-Methode
	 * Zeichnet das Koordinatensystem und die Sinus- und Cosinus-Linie
	 * @param Graphics g
	 */
	public void paint(Graphics g) {
		super.paint(g);
		//farbe auf schwarz
		g.setColor(Color.BLACK);
		//waagrechte Koordinatenlinie
		g.drawLine(umrechnungX(WELT_X0), umrechnungY(0), umrechnungX(WELT_X1), umrechnungY(0));
		//Senkrechte Koordinatenlinie
		g.drawLine(umrechnungX(0), umrechnungY(WELT_Y0), umrechnungX(0), umrechnungY(WELT_Y1));
		//schrittweise von -10 bis 10 (also max. in X-Richtung)
		for(double i = WELT_X0; i < WELT_X1; i = i+0.0001) {
			//Sinus wird berechnet und ist der Wert der Y-Achse
			double y = Math.sin(i);
			//Linie wird gezeichnet
            g.drawLine(umrechnungX(i), umrechnungY(y), umrechnungX(i), umrechnungY(y));
            //Cosinus wird berechnet und ist der Wert der Y-Achse
            y = Math.cos(i);
            //Linie wird gezeichnet
            g.drawLine(umrechnungX(i), umrechnungY(y), umrechnungX(i), umrechnungY(y));
        }
	}

}
