package net.tfobz.tictactoe;

public class TicTacToeZoeschg
{

	public static final int SPIELER1 = -1;
	public static final int SPIELER2 = -2;
	private int[][] spielfeld;

	/**
	 * Konstruktor initialisiert das Spielfeld mit Zahlen beginnend bei 0.
	 * 
	 * @param feldgroesse
	 *          die Feldgröße
	 */
	public TicTacToeZoeschg(int feldgroesse) {
		if (feldgroesse < 3) {
			feldgroesse = 3;
		}
		this.spielfeld = new int[feldgroesse][feldgroesse];
		for (int i = 0; i < feldgroesse; i++) {
			for (int j = 0; j < feldgroesse; j++) {
				this.spielfeld[i][j] = i * feldgroesse + j;
			}
		}
	}

	/**
	 * @return the spieler1
	 */
	public static int getSpieler1() {
		return SPIELER1;
	}

	/**
	 * @return the spieler2
	 */
	public static int getSpieler2() {
		return SPIELER2;
	}

	/**
	 * Zeilenweise Ausgabe des Spielfeldes. Dabei werden an den gesetzten Postionen
	 * nicht die Spielernummern ausgegeben sondern für den ersten Spieler ein X und
	 * für den zweiten ein O.
	 * 
	 * @return die Zeilenweise Ausgabe des Spielfeldes als String
	 */
	public String toString() {
		int feldgroesse = this.spielfeld.length;
		String s = "";
		for (int i = 0; i < feldgroesse; i++) {
			for (int j = 0; j < feldgroesse; j++) {
				int zahl =i * feldgroesse + j;
				if(spielfeld[i][j] == SPIELER1 || spielfeld[i][j] == SPIELER2) {
					zahl = 1;
				}
				if (zahl == 0) {
					for (int n = 0; n < (int) Math.log10(Math.pow(feldgroesse, 2) - 1); n++) {
						s = s + " ";
					}
				} else {
					for (int n = (int) Math.log10(zahl); n < (int) Math.log10(Math.pow(feldgroesse, 2) - 1); n++) {
						s = s + " ";
					}
				}
				if (spielfeld[i][j] == SPIELER1) {
					s = s + "X";
				} else if (spielfeld[i][j] == SPIELER2) {
					s = s + "O";
				} else {
					s = s + spielfeld[i][j];
				}
				if (spielfeld.length != 3) {
					s = s + " ";
				}
			}
			s = s + "\n";
		}
		s = s.substring(0, s.length() - 1);
		return s;
	}

	/**
	 * Liefert die Feldgröße des Spielfeldes zurück
	 * 
	 * @return die Feldgröße
	 */
	public int getFeldgroesse() {
		return this.spielfeld.length;
	}

	/**
	 * Ermittelt wie das Spielfeld an der Stelle zeile/spalte gesetzt ist
	 * 
	 * @param zeile
	 *          die Zeile des Spielfelds an der nachgeschaut werden soll
	 * @param spalte
	 *          die Spalte des Spielfelds an der nachgeschaut werden soll
	 * @return 0 falls an der übergebenen Position noch kein Spieler gesetzt hat
	 *         SPIELER1 falls an der übergebenen Position der erste Spieler gesetzt
	 *         hat SPIELER2 falls an der übergebenen Position der zweite Spieler
	 *         gesetzt hat -3 falls zeile und/oder spalte außerhalb des Spielfeldes
	 *         zugreifen wollen
	 */
	public int getSpielfeld(int zeile, int spalte) {
		int ret;
		if (zeile < 0 || zeile > this.spielfeld.length || spalte < 0 || spalte > this.spielfeld.length) {
			ret = -3;
		} else {
			switch (spielfeld[zeile][spalte]) {
				case (SPIELER1): {
					ret = SPIELER1;
					break;
				}
				case (SPIELER2): {
					ret = SPIELER2;
					break;
				}
				default: {
					ret = 0;
				}
			}
		}
		return ret;
	}

	/**
	 * Setzt den Zug des Spielers 1
	 * 
	 * @param zug
	 * @return int
	 */
	public int setZugSpieler1(int zug) {
		return setZug(zug, SPIELER1);
	}

	/**
	 * Setzt den Zug des Spielers 2
	 * 
	 * @param zug
	 * @return int
	 */
	public int setZugSpieler2(int zug) {
		return setZug(zug, SPIELER2);
	}

	/**
	 * Setzt den �bergebenen Zug im Spielfeld f�r den Spieler dessen Nummer
	 * ebenfalls �bergeben wurde
	 * 
	 * @param zug
	 * @param spielernummer
	 * @return 0 falls Zug erfolgreich gesetzt werden konnte -1 falls der Zug
	 *         au�erhalb des Spielfeldes liegt -2 falls der Zug bereits gesetzt
	 *         wurde
	 */
	private int setZug(int zug, int spielernummer) {
		int ret = 0;
		if (zug >= Math.pow(this.spielfeld.length, 2) || zug < 0) {
			ret = -1;
		} else if (this.spielfeld[zug / spielfeld.length][zug % this.spielfeld.length] < 0) {
			ret = -2;
		} else {
			this.spielfeld[zug / spielfeld.length][zug % this.spielfeld.length] = spielernummer;
		}
		return ret;
	}

	/**
	 * Ermittelt die Nummer des Spielers der gewonnen hat
	 * 
	 * @return 0 derzeit hat noch niemand gewonnen SPIELER1 oder SPIELER2
	 */
	public int getGewonnen() {
		int ret = 0;
		boolean eins = true;
		boolean zwei = true;
		int laenge = this.spielfeld.length;

		// sucht nach horizontalen Siegen
		for (int i = 0; i < laenge && ret == 0; i++) {
			for (int j = 0; j < laenge && (eins == true || zwei == true); j++) {
				switch (this.spielfeld[i][j]) {
					case (SPIELER1): {
						zwei = false;
						break;
					}
					case (SPIELER2): {
						eins = false;
						break;
					}
					default: {
						eins = false;
						zwei = false;
					}
				}
			}
			if (eins == true) {
				ret = SPIELER1;
			} else if (zwei == true) {
				ret = SPIELER2;
			}
			eins = true;
			zwei = true;
		}

		// sucht nach vertikalen Siegen
		for (int i = 0; i < laenge && ret == 0; i++) {
			for (int j = 0; j < laenge && (eins == true || zwei == true); j++) {
				switch (this.spielfeld[j][i]) {
					case (SPIELER1): {
						zwei = false;
						break;
					}
					case (SPIELER2): {
						eins = false;
						break;
					}
					default: {
						eins = false;
						zwei = false;
					}
				}
			}
			if (eins == true) {
				ret = SPIELER1;
			} else if (zwei == true) {
				ret = SPIELER2;
			}
			eins = true;
			zwei = true;
		}

		// sucht nach diagonalen Siegen
		for (int i = 0; i < laenge && ret == 0; i++) {
			switch (this.spielfeld[i][i]) {
				case (SPIELER1): {
					zwei = false;
					break;
				}
				case (SPIELER2): {
					eins = false;
					break;
				}
				default: {
					eins = false;
					zwei = false;
				}
			}
		}
		if (eins == true) {
			ret = SPIELER1;
		} else if (zwei == true) {
			ret = SPIELER2;
		}
		eins = true;
		zwei = true;
		for (int i = 0; i < laenge && ret == 0; i++) {
			switch (this.spielfeld[i][laenge - 1 - i]) {
				case (SPIELER1): {
					zwei = false;
					break;
				}
				case (SPIELER2): {
					eins = false;
					break;
				}
				default: {
					eins = false;
					zwei = false;
				}
			}
		}
		if (eins == true) {
			ret = SPIELER2;
		} else if (zwei == true) {
			ret = SPIELER1;
		}
		eins = true;
		zwei = true;
		return ret;
	}

	/**
	 * Ermittelt ob einer der Spieler das Spiel noch gewinnen kann
	 * 
	 * @return true falls das Spiel noch gewonnen werden kann
	 */
	public boolean getEinerKannGewinnen() {
		boolean ret = false;
		boolean eins = true;
		boolean zwei = true;
		int laenge = this.spielfeld.length;
		int zug = 0;
		for (int i = 0; i < laenge; i++) {
			for (int j = 0; j < laenge; j++) {
				if (spielfeld[i][j] != 0) {
					zug++;
				}
			}
		}
		if (zug % 2 == 0) {
			zug = SPIELER2;
		} else {
			zug = SPIELER1;
		}
		// sucht nach horizontalen Siegesmöglichkeiten
		for (int i = 0; i < laenge && ret == false; i++) {
			for (int j = 0; j < laenge && (eins == true || zwei == true); j++) {
				switch (this.spielfeld[i][j]) {
					case (SPIELER1): {
						zwei = false;
						break;
					}
					case (SPIELER2): {
						eins = false;
						break;
					}
				}
			}
			if (eins == true && zug == SPIELER1 || zwei == true && zug == SPIELER2) {
				ret = true;
			}
			eins = true;
			zwei = true;
		}

		// sucht nach vertikalen Siegesmöglichkeiten
		for (int i = 0; i < laenge && ret == false; i++) {
			for (int j = 0; j < laenge && (eins == true || zwei == true); j++) {
				switch (this.spielfeld[j][i]) {
					case (SPIELER1): {
						zwei = false;
						break;
					}
					case (SPIELER2): {
						eins = false;
						break;
					}
				}
			}
			if (eins == true && zug == SPIELER1 || zwei == true && zug == SPIELER2) {
				ret = true;
			}
			eins = true;
			zwei = true;
		}

		// sucht nach diagonalen Siegesmöglichkeiten
		for (int i = 0; i < laenge && ret == false; i++) {
			switch (this.spielfeld[i][i]) {
				case (SPIELER1): {
					zwei = false;
					break;
				}
				case (SPIELER2): {
					eins = false;
					break;
				}
			}
		}
		if (eins == true && zug == SPIELER1 || zwei == true && zug == SPIELER2) {
			ret = true;
		}
		eins = true;
		zwei = true;
		for (int i = 0; i < laenge && ret == false; i++) {
			switch (this.spielfeld[i][laenge - 1 - i]) {
				case (SPIELER1): {
					zwei = false;
					break;
				}
				case (SPIELER2): {
					eins = false;
					break;
				}
			}
		}
		if (eins == true && zug == SPIELER1 || zwei == true && zug == SPIELER2) {
			ret = true;
		}
		return ret;
	}

}
