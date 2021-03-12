import java.awt.*;
import java.applet.*;

public class test01 extends Applet {

	public void paint(Graphics g) {

		// Fixe Anzahl von Zeilen und Spalten
		final int ANZAHL_ZEILEN = 9;
		final int ANZAHL_SPALTEN = 9;

		// Maximale Anzahl von Iterationsschritten
		final int MAX_SCHRITTE = 150;

		// Instanziiren von matrix1 und matrix2
		boolean[][] matrix1 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];
		boolean[][] matrix2 = new boolean[ANZAHL_ZEILEN][ANZAHL_SPALTEN];

		// Matrix1 wird mit leben gefüllt
		matrix1 = fuellenMatrixSternMitte(matrix1, 1);

		// Deklarieren und initialisieren vom Schrittzähler
		int i = 0;

		/*
		 * Wiederhole solange Schrittzähler kleiner MAX_SCHRITTE und Unterschiede
		 * zwischen Matrix1 und Matrix2
		 */
		do {
			ausgebenMatrix(g, matrix1);
			matrix2 = matrix1;
			matrix1 = berechneMatrix(matrix1);
			bremse(300);
			i++;
			
		}
		while(i < MAX_SCHRITTE && existierenUnterschiede(matrix1, matrix2));
		
	}

	/**
	 * Füllt das übergebene Array mit einem Stern der größe groesse in der Mitte des
	 * Arrays, das aus true besteht. Falls groesse 0 ist wird nur der boolean in der
	 * Mitte true.
	 * 
	 * @param matrix1
	 *            Das Array in dem der Stern eingefühgt werden soll
	 * @param groesse
	 *            Die größe des Sterns
	 * @return Gibt das Array mit dem Stern zurück.
	 */
	public static boolean[][] fuellenMatrixSternMitte(boolean[][] matrix1, int groesse) {

		boolean[][] ret = matrix1;

		// Finden der Mitte der Matrix
		int reihenmitte = (matrix1.length - 1) / 2;
		int spaltenmitte = (matrix1[reihenmitte].length - 1) / 2;

		// Je nach dem wie groß groesse ist wird ein größerer Stern eingefügt
		for (int i = 0; i <= groesse; i++) {
			matrix1[reihenmitte + i][spaltenmitte] = true;
			matrix1[reihenmitte - i][spaltenmitte] = true;
			matrix1[reihenmitte][spaltenmitte + i] = true;
			matrix1[reihenmitte][spaltenmitte - i] = true;
		}

		// Gibt das Array zurück
		return ret;
	}

	public void ausgebenMatrix(Graphics g, boolean[][] matrix1) {

		// Ermittle die Breite und Höhe des Applets in Pixel
		int breite = getWidth();
		int hoehe = getHeight();
		System.out.println("breite: " + breite);
		System.out.println("hoehe: " + hoehe);

		int zeilen = matrix1.length;
		int spalten = matrix1[0].length;

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				if (matrix1[i][j] == false) {
					g.setColor(Color.gray);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect((breite / spalten) * j, (hoehe / zeilen) * i, breite / spalten + 1, hoehe / zeilen + 1);
				g.setColor(Color.white);
				g.drawLine((breite / spalten) * j, 0, (breite / spalten) * j, hoehe);
			}
			g.setColor(Color.white);
			g.drawLine(0, (hoehe / zeilen) * i, breite, (hoehe / zeilen) * i);
		}

	}

	/**
	 * Diese Methode ermittelt in der übergebenen Matrix, wie viele lebende
	 * Nachbaren ein Feld hat. Das zu analysierende Feld wird durch seine Zeilen-
	 * und Spaltenposition übergeben. Falls das Feld keine lebende Nacharfelde hat
	 * oder die Zeilen- und Spaltenposition kleiner oder größer als die Matrix ist
	 * wird 0 zurückgegeben.
	 * 
	 * @param matrix1
	 *            Matrix in der die Nachbaren eines Feldes ermittelt werden sollen
	 * @param zeile
	 *            Die Zeile in dem sich das Feld befindet
	 * @param spalte
	 *            Die Spalte in dem sich das Feld befindet
	 * @return Die Anzahl der Nachbarfelder
	 */
	public static int anzahlLebendeNachbaren(boolean[][] matrix1, int zeile, int spalte) {
		int ret = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				// Überprüfen ob eines der Felder außerhalb der Matrix ist
				if (zeile + i >= 0 && zeile + i <= matrix1.length - 1 && spalte + j >= 0
						&& spalte + j <= matrix1[0].length - 1) {

					if (matrix1[zeile + i][spalte + j] == true) {
						// Das Feld in der Mitte wird nicht gezählt
						if (i == 0 && i == j) {

						} else {
							ret++;
						}
					}
				}
			}
		}

		return ret;
	}

	public static boolean[][] berechneMatrix(boolean[][] matrix1) {
		boolean[][] ret = new boolean[matrix1.length][matrix1[0].length];
		boolean feld = true;
		int anzahl = 0;

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {

				feld = matrix1[i][j];
				anzahl = anzahlLebendeNachbaren(matrix1, i, j);

				if (feld == true) {
					/*
					 * Hat ein lebendes Feld weniger als 2 lebende Nachbarfelder, dann geht es aus
					 * Einsamkeit zugrunde. Hat ein lebendes Feld mehr als 3 lebende Nachbarfelder,
					 * dann stirbt es wegen Überbevölkerung.
					 */
					if (anzahl < 2 || anzahl > 3) {
						ret[i][j] = false;
					} else {
						ret[i][j] = true;
					}
				} else {
					// Neues Leben entsteht, wenn ein totes Feld genau 3 lebende Nachbarfelder hat.
					if (anzahl == 3) {
						ret[i][j] = true;
					}
				}
			}
		}
		return ret;
	}

	public static boolean existierenUnterschiede(boolean[][] matrix1, boolean[][] matrix2) {
		boolean ret = false;
		int falschwerte = 0;
		if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
			for (int i = 0; i < matrix1.length; i++) {
				for (int j = 0; j < matrix2[i].length; j++) {
					if (matrix1[i][j] != matrix2[i][j]) {
						falschwerte++;
					}
				}
			}
			if (falschwerte > 0) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Veranlasst dass das Programm millis Millisekunden pausiert
	 * 
	 * @param millis
	 *            Anzahl der Millisekunden die gewartet werden
	 */
	public void bremse(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

}