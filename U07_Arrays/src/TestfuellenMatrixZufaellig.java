/**
 * importiert die Pakete java.awt und java.applet, damit im Applet die Klassen
 * Applet und Graphics verwendet werden können
 */
import java.awt.*;
import java.applet.*;
public class TestfuellenMatrixZufaellig extends Applet{

	public void paint(Graphics g) {
		// Fixe Anzahl von Zeilen und Spalten
		final int ANZAHL_ZEILEN = 20;
		final int ANZAHL_SPALTEN = 20;
		// Maximale Anzahl von Iterationsschritten
		final int MAX_SCHRITTE = 150;
		boolean[][] matrix1 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		boolean[][] matrix2 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		int counter = 0;
		//Aufruf Matirx zufällig füllen
		GameOfLife.fuellenMatrixZufaellig(matrix1, 0.3);
		do {
			//Aufruf der Ausgeben-Methode
			ausgebenMatrix(matrix1, g, ANZAHL_SPALTEN, ANZAHL_ZEILEN);
			matrix2 = GameOfLife.cpArray(matrix1);
			matrix1 = GameOfLife.berechneMatrix(matrix1);
			counter++;
			bremse(150);
			
		} while (counter < MAX_SCHRITTE && GameOfLife.existierenUnterschiede(matrix1, matrix2));
	
	}

	/**
	 * Befüllt die Matrix mit einem Stern, der in der Mitte der Matrix positioniert wird. Die Größe 
	 * des Sterns hängt vom übergebenen Parameter groesse ab.
	 * @param matrix, die Matrix, in welche ein Stern gezeichnet wird
	 * @param groesse, gibt die größe des Sterns an
	 * @return, Rückgabe der Matrix mit Stern, als zweidimensionales boolean-Array
	 */
	public void ausgebenMatrix (boolean [][] matrix1, Graphics g, int spalten, int zeilen ) {
		// Ermittle die Breite und Höhe des Applets in Pixel
		int breite = getWidth();
		int hoehe = getHeight();
		//Alle Elemente des zweidimensionalen Arrays werden angesteuert
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				//Wenn element gleich false, dann farbe ist grau
				if (matrix1[i][j] == false) {
					g.setColor(Color.gray);
				}
				//Wenn element gleich true, dann farbe ist schwarz
				else {
					g.setColor(Color.black);
				}
				//Ausgabe der Quadrate
				g.fillRect((breite / spalten)*j, (hoehe / zeilen)*i, breite / spalten+1, hoehe / zeilen+1);
				//Weisse Farbe
				g.setColor(Color.white);
				//Linie wird gezeichnet, zur abgrenzung, senkrecht
				g.drawLine((breite / spalten)*j, 0, (breite / spalten)*j, hoehe);
			}
			//Weisse Farbe
			g.setColor(Color.white);
			//Linie wird gezeichnet, zur abgrrenzung, wagrecht
			g.drawLine(0, (hoehe / zeilen)*i, breite, (hoehe / zeilen)*i);
		}
	}
	
	/**
	* Veranlasst dass das Programm millis Millisekunden pausiert
	* @param millis Anzahl der Millisekunden die gewartet werden
	*/
	public void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	

}
