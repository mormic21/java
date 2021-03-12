/**
 * importiert die Pakete java.awt und java.applet, damit im Applet die Klassen
 * Applet und Graphics verwendet werden können
 */
import java.awt.*;
import java.applet.*;
public class GameOfLife extends Applet{
	
	
	@Override
	public void paint(Graphics g) {
		// Fixe Anzahl von Zeilen und Spalten
		final int ANZAHL_ZEILEN = 9;
		final int ANZAHL_SPALTEN = 9;
		// Maximale Anzahl von Iterationsschritten
		final int MAX_SCHRITTE = 150;
		boolean[][] matrix1 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		boolean[][] matrix2 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		//Aufruf Matirx mit Stern füllen
		fuellenMatrixSternMitte(matrix1, 1);
		//GameOfLife.fuellenMatrixZufaellig(matrix1, 0.3);
		int counter = 0;
		do {
			//Aufruf der Ausgeben-Methode
			ausgebenMatrix(matrix1, g, ANZAHL_SPALTEN, ANZAHL_ZEILEN);
			matrix2 = cpArray(matrix1);
			matrix1 = berechneMatrix(matrix1);
			counter++;
			bremse(300);
			
		} while (counter < MAX_SCHRITTE && existierenUnterschiede(matrix1, matrix2));
	
	}
	
	/**
	 * Befüllt die Matrix mit einem Stern, der in der Mitte der Matrix positioniert wird. Die Größe 
	 * des Sterns hängt vom übergebenen Parameter groesse ab.
	 * @param matrix, die Matrix, in welche ein Stern gezeichnet wird
	 * @param groesse, gibt die größe des Sterns an
	 * @return, Rückgabe der Matrix mit Stern, als zweidimensionales boolean-Array
	 */
	public static boolean [][] fuellenMatrixSternMitte (boolean[][] matrix, int groesse) {
		boolean [][] ret  = null;
		//Wenn groesse gleich 0 ist, so wird nur das Feld in der Mitte auf true gesetzt
		if (groesse <= (matrix.length - 1)/2 && groesse <= (matrix[0].length - 1)/2) {
			ret = matrix;
			if (groesse == 0) {
				//Sucht beide male die Mitte
				int mittereihe = (matrix.length-1)/2;
				int mittespalte = (matrix[mittereihe].length-1)/2;
				//Auf true setzen
				ret[mittereihe][mittespalte] = true;
			}
			//Wenn groesse größer als 0 ist.....
			else {
				//Mitte wird bestimmt
				int mittereihe = (matrix.length-1)/2;
				int mittespalte = (matrix[mittereihe].length-1)/2;
				//Mitteltes Feld auf true
				ret[mittereihe][mittespalte] = true;
				//Je nach größe werden die Felder oberhalb des mittelnen Feldes auf true gesetzt
				for (int i = 0; i < groesse; i++) {
					ret[mittereihe-i-1][mittespalte] = true;
					ret[mittereihe][mittespalte+i+1] = true;
					ret[mittereihe+i+1][mittespalte] = true;
					ret[mittereihe][mittespalte-i-1] = true;
				}
			}
		}
		else {
			System.out.println("groesse zu groß für das übergebende Array");
		}
		
		//Rückgabe
		return ret;
	}
	/**
	 * Gibt das übergebene, zweidimensionale Array in einem Applett aus. Dabei werden die Felder
	 * des Arrays, welche auf true sind schwarz eingefärbt. Felder des Arrays die ein false enthalten
	 * werden grau eingefärbt.
	 * @param matrix1, die auszugebene Methode
	 * @param g, die Zeichenfläche des Appletts
	 * @param ANZAHL_SPALTEN, anzahl der Spalten der matrix
	 * @param ANZAHL_ZEILEN, anzahl der Zeilen der matrix
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
	 * Ermittelt in der übergebenden Matrix an der übergebenden Position die Anzahl der Felder,
	 * welche "Leben" in sich haben, also in welchen der Wert True gespeichert ist. Das Ergebnis wird als
	 * Integer zurückgeliefert. 
	 * @param matrix, die Matrix mit dem zu analysierenden Feld
	 * @param zeile, Angabe der Zeile wo sich das zu analysierende Feld befindet
	 * @param spalte, Angabe der Spalte wo sich das zu analysierende Feld befindet
	 * @return, die Anzahl lebender Nachbarn, als Integer
	 */
	public static int anzahlLebendeNachbaren(boolean[][] matrix, int zeile, int spalte) {
		//Rückgabevariable
		int ret = 0;
		//Alle Felder um das übergebene Feld werden auf True geprüft. Wenn true, dann wird die Variable erhöht.
        if (spalte != 0 && matrix[zeile][spalte - 1]) {
            ret++;
        }
        if (spalte != 0 && zeile != 0 && matrix[zeile - 1][spalte - 1] && matrix[zeile - 1][spalte - 1]) {
            ret++;
        }
        if (spalte != 0 && zeile < matrix[1].length - 1 && matrix[zeile + 1][spalte - 1]) {
            ret++;
        }
        if (zeile != 0 && matrix[zeile - 1][spalte]) {
        	ret++;
            }
        if (zeile != 0 && spalte < matrix[1].length - 1 && matrix[zeile - 1][spalte + 1]) {
            ret++;
        }
        if (zeile < matrix[1].length - 1 && matrix[zeile + 1][spalte]) {
            ret++;
        }
        if (spalte < matrix.length - 1 && matrix[zeile][spalte + 1]) {
            ret++;
        }
        if (spalte < matrix.length - 1 && zeile < matrix[1].length - 1 && matrix[zeile + 1][spalte + 1]) {
            ret++;
        }
        //Rückgabe
        return ret;
    }
	
	/**
	 * Berechnet aus der übergebenen Matrix mit den Regeln des "Game of Life" den nächsten
	 * Lebenszyklus der Matrix und gibt diesen dann in einer neuen Matrix zurück.
	 * @param matrix, aus welcher der neue Lebenszyklus berechnet wird
	 * @return eine Matrix mit dem nächsten Lebenszyklus
	 */
	public static boolean [][] berechneMatrix(boolean [][] matrix) {
		boolean [][] ret = new boolean[matrix.length][matrix[0].length];
		int anzahl = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				anzahl = anzahlLebendeNachbaren(matrix, i, j);
				//Für jedes Element des zweidimensionalen Arrays werden die Regeln durchgegangen
				//Wenn das Feld lebend ist...
				if (matrix[i][j] == true) {
					/*
					 * Hat ein lebendes Feld weniger als 2 lebende Nachbarfelder, dann geht es aus
					 * Einsamkeit zugrunde. Hat ein lebendes Feld mehr als 3 lebende Nachbarfelder,
					 * dann stirbt es wegen Überbevölkerung.
					 */
					if (anzahl < 2 || anzahl > 3) {
						ret[i][j] = false;
					}
					else {
						ret[i][j] = true;
					}
				}
				//Wenn das Feld tot ist
				else {
					/*
					 * Neues Leben entsteht, wenn ein totes Feld genau 3 lebende Nachbarfelder hat.
					 */
					if (anzahl == 3) {
						ret[i][j] = true;
					}
				}
			}
		}
		//Rückgabe
		return ret;
	}
	
	/**
	 * Untersucht die zwei übergebenden Matrizen auf Unterschiede. Sind Matrix1 und Matrix2 nicht gleich,
	 * so wird true zurückgeliefert. Ansonsten wird false zurückgeliefert.
	 * @param matrix1, die erste Matrix
	 * @param matrix2, die zweite Matrix
	 * @return, ein boolean, True bei Unterschieden, ansonsten False
	 */
	public static boolean existierenUnterschiede(boolean [][] matrix1, boolean [][] matrix2) {
		boolean ret = false;
		//Variablendekalration
		int anders = 0;
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				//Zählt unterschiede
				if (matrix1[i][j] != matrix2 [i][j]) {
					anders++;
				}
			}
		}
		//Wenn unterschiede, dann True
		if (anders > 0) {
			ret = true;
		}
		return ret;
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
	
	/**
	 * Kopiert ein zweidimmensionales Array und gibt die Kopie anschließend zurück
	 * @param matrix, das zu kopierende, zweidimmensionale Array
	 * @return, die Kopie
	 */
	public static boolean [][] cpArray(boolean [][] matrix) {
		boolean [][] ret = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				ret[i][j] = matrix[i][j];
			}
		}
		return ret;
	}
	
	/**
	 * Füllt eine übergebene Matrix zurfällig mit Leben. Die Anzahl der lebenden Positionen
	 * wird mit dem Parameter realtion gesteuert, welches das Verhältnis zwischen gefüllten und
	 * nicht gefüllten Positionen sein soll. Das Verhältnis 0.1 bedeutet, zum Beispiel, dass 10% 
	 * der Fehler mit Leben gefüllt werden.
	 * @param matrix, die zu füllende boolean-Matrix
	 * @param relation, Verhältnis, in welchem die Matrix mit lebenden Feldern gefüllt wird
	 * @return, das zweidimensionale, zufällig, befüllte boolean-Array
	 */
	public static boolean [][] fuellenMatrixZufaellig(boolean [][] matrix, double relation) {
		boolean [][] ret = matrix;
		//Die Anzahl an zufalligen Feldern wird berechnet
		int anzahl = (int)((matrix.length * matrix[0].length) * relation);
		int count = 0;
		//Variablendeklarationen für Random
		int bis = matrix.length;
		int bis2 = matrix[0].length;
		//While - zufälliges Füllen
		while (count < anzahl) {
			//Zufällige Position wird ermittelt
			int i = (int)(Math.random()*bis);
			int j = (int)(Math.random()*bis2);
			//Ist der Wert an der ermittelten Position false, so wird sie true und der Zähler wird erhöht
			if (matrix[i][j] == false) {
				matrix[i][j] = true;
				count++;
			}
		}
		//Rückgabe
		return ret;
	}
}
