package net.tfobz.tictactoe;

public class TicTacToe {
	// Das Spielfeld
	private int[][] spielfeld;
	// Nummer des ersten Spielers
	public static final int SPIELER1 = -1;
	// Nummer des zweiten Spielers
	public static final int SPIELER2 = -2;

	/**
	 * Konstruktor initialisiert das Spielfeld mit Zahlen beginnend bei 0. Ist die
	 * Feldgroesse kleiner als 3 dann wird diese auf 3 gesetzt und ein
	 * entsprechendes Spielfeld angelegt. Ist beispielsweise die Feldgroesse auf 3
	 * eingestellt, so wird das Spielfeld folgendermassen initialisiert: 
	 * 0 1 2 
	 * 3 4 5
	 * 6 7 8
	 * @param feldgroesse,
	 *            groesse des Feldes
	 */
	public TicTacToe(int feldgroesse) {
		if (feldgroesse < 3) {
			feldgroesse = 3;
		}
		spielfeld = new int[feldgroesse][feldgroesse];
		int number = 0;
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				spielfeld[i][j] = number;
				number++;
			}
		}
	}

	/**
	 * Zeilenweise Ausgabe des Spielfeldes. Dabei werden an den gesetzten Postionen
	 * nicht die Spielernummern ausgegeben sondern fuer den ersten Spieler ein X und
	 * fuer den Zweiten ein O (O wie Otto). Beispielsweise wird fuer das Spielfeld
	 *  0 1-1 
	 *  3-2-1 
	 *  6 7 8 
	 *  folgendes zurueck gegeben: 
	 *  01X 
	 *  3OX 
	 *  678
	 * @return das Spielfeld aufgeteilt auf mehrere Zeilen als String
	 */
	@Override
	public java.lang.String toString() {
		String ret = null;
		int number;
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				number = spielfeld[i][j];
				if (number >= 0) {
					ret = ret + number;
				} else {
					if (number == SPIELER1) {
						ret = ret + "X";
					}
					if (number == SPIELER2) {
						ret = ret + "O";
					}
				}
			}
			ret = ret + "\n";
		}
		return "ok";
	}
	
	/**
	 * Liefert die Feldgroesse des Spielfeldes zurueck
	 * @return die Feldgroesse des Spielfeldes, als int
	 */
	public int getFeldgroesse() {
		return spielfeld.length;
	}
	
	/**
	 * Ermittelt wie das Spielfeld an der Stelle zeile/spalte gesetzt ist
	 * @param zeile des Spielfeldes an der nachgeschaut werden soll
	 * @param spalte des Spielfeldes an der nachgeschaut werden soll
	 * @return
	 *  - 0 falls an der uebergebenen Position noch kein Spieler gesetzt hat
	 *  - SPIELER1 falls an der uebergebenen Position der erste Spieler gesetzt hat
	 *  - SPIELER2 falls an der uebergebenen Position der zweite Spieler gesetzt hat
	 *  - 3 falls zeile und/oder spalte ausserhalb des Spielfeldes zugreifen wollen
	 */
	public int getSpielfeld(int zeile, int spalte) {
		int ret = 0;
		if (zeile >= getFeldgroesse()) {
			ret = -3;
		}
		else {
			if (spalte >= getFeldgroesse()) {
				ret = -3;
			}
			else {
				if (spielfeld[zeile][spalte] == SPIELER1) {
					ret = SPIELER1;
				}
				else {
					if (spielfeld[zeile][spalte] == SPIELER2) {
						ret = SPIELER2;
					} 
				}
			}
		}
		return ret;
	}
	
	private int setZug(int zug, int spielernummer) {
		return 0;
	}

	

	

}
