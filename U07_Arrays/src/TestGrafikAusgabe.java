/**
 * importiert die Pakete java.awt und java.applet, damit im Applet die Klassen
 * Applet und Graphics verwendet werden k�nnen
 */
import java.awt.*;
import java.applet.*;

/**
 * Testapplet, welches zeigt wie Rechtecke und Linien in verschiedenen Farben auf
 * einer Zeichenfl�che im Applet ausgegeben werden k�nnen.
 * ACHTUNG: Java-Applets m�ssen anders gestartet werden als normale Java-Programme
 * @author Michael Wild
 *
 * Die Klasse TestGrafikAusgabe ist von der Klasse Applet abgeleitet und erbt somit
 * alle Eigenschaften, die ein Applet hat. Durch die Ableitung (Vererbung) wird die
 * Klasse TestGrafikAusgabe zum Applet
 */
public class TestGrafikAusgabe extends Applet
{
  /**
   * Diese Methode wird aufgerufen, wenn zum ersten Mal das Applet am Bildschirm
   * erscheint. Sie wird aber auch dann aufgerufen, wenn das Applet neu am Bildschirm
   * dargestellt werden muss (z. B. bei Gr��en�nderung)
   */
	public void paint(Graphics g) {
		// Ermittle die Breite und H�he des Applets in Pixel
    int breite = getWidth();
    int hoehe = getHeight();
    // Setze die Farbe des Zeichenstiftes auf gr�n. Alle nachfolgenden ausgegebenen
    // Zeichnungen werden in dieser Farbe dargestellt
    g.setColor(Color.green);
    // Ausgabe eines gef�llten Rechtecks
    g.fillRect(breite / 2 - breite / 4,hoehe / 2 - hoehe / 4,breite / 2, hoehe / 2);
    g.setColor(Color.black);
    // Ausgabe einer Linie
    g.drawLine(0,0,breite,hoehe);
    System.out.println("hal");
    g.setColor(Color.red);
    g.drawLine(breite,0,0,hoehe);
  }
}