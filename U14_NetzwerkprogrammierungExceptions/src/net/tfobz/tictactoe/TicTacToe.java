package net.tfobz.tictactoe;
/**
 * Klasse mit Methoden zur Realisierung des Spiels "Tic Tac Toe"
 * @author Michael Morandell
 *
 */
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
		//spielfeld wird initialisert
		spielfeld = new int[feldgroesse][feldgroesse];
		int number = 0;
		//nummern werden eingetragen
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
		String ret = "";
		int number;
		int space;
		//größte auszugebende Zahl wird berechnet
		int biggestnum = (int)(Math.pow((double)getFeldgroesse(),(double) 2))-1;
		//berechnung der nötigen Leerzeichen
		int allspaces = String.valueOf(biggestnum).length();
		if (allspaces != 1) {
			allspaces++;
		}
		//Umwandlung in einen String mit erforderlichen Leerzeichen
		for (int i = 0; i < getFeldgroesse(); i++) {
			for (int j = 0; j < getFeldgroesse(); j++) {
				number = spielfeld[i][j];
				if (number >= 0) {
					space = allspaces - String.valueOf(number).length();
					//leerzeichen einfuegen
					for (int n = 0; n < space; n++) {
						ret = ret + " ";
					}
					ret = ret + number;
				} else {
					if (number == SPIELER1) {
						space = allspaces - 1;
						//leerzeichen einfuegen
						for (int n = 0; n < space; n++) {
							ret = ret + " ";
						}
						ret = ret + "X";
					}
					if (number == SPIELER2) {
						space = allspaces - 1;
						//leerzeichen einfuegen
						for (int n = 0; n < space; n++) {
							ret = ret + " ";
						}
						ret = ret + "O";
					}
				}
			}
			ret = ret + "\n";
		}
		//das letzte \n wird entfernt
		ret = ret.substring(0, ret.length()-1);
		//return
		return ret;
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
	 *  - -3 falls zeile und/oder spalte ausserhalb des Spielfeldes zugreifen wollen
	 */
	public int getSpielfeld(int zeile, int spalte) {
		int ret = 0;
		//ausserhalb des Spielfeldes
		if (zeile >= getFeldgroesse()) {
			ret = -3;
		}
		else {
			//ausserhalb des Spielfeldes
			if (spalte >= getFeldgroesse()) {
				ret = -3;
			}
			else {
				//Spieler1
				if (spielfeld[zeile][spalte] == SPIELER1) {
					ret = SPIELER1;
				}
				else {
					//Spieler2
					if (spielfeld[zeile][spalte] == SPIELER2) {
						ret = SPIELER2;
					} 
				}
			}
		}
		//return
		return ret;
	}
	
	/**
	 * Setzt den uebergebenen Zug im Spielfeld fuer den Spieler dessen Nummer ebenfalls uebergeben wurde
	 * @param zug
	 * @param spielernummer
	 * @return 
	 *  0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug ausserhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 */
	private int setZug(int zug, int spielernummer) {
		int ret = 0;
		int zeile = 0;
		int spalte = zug;
		//Berechnung der Koordinaten der Zugnummer
		while (spalte >= getFeldgroesse()) {
			spalte = spalte - getFeldgroesse();
			zeile++;
		}
		int spielret = getSpielfeld(zeile, spalte);
		switch(spielret) {
			//Wenn Zug ausserhalb des Spielfeldes
			case -3: {
				ret = -1;
				break;
			}
			//Wenn Zug von Spieler1 belegt
			case SPIELER1: {
				ret = -2;
				break;
			}
			//Wenn Zug von Spieler2 belegt
			case SPIELER2: {
				ret = -2;
				break;
			}
			//Wenn Zug frei
			case 0: {
				//zug wird gesetzt
				spielfeld[zeile][spalte] = spielernummer;
				break;
			}
		}
		//return
		return ret;
	}
	
	/**
	 * Setzt den Zug des Spielers 1
	 * @param zug, den zu setzenden Zug
	 * @return
	 *  0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug ausserhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 */
	public int setZugSpieler1(int zug) {
		return setZug(zug, SPIELER1);
	}
	
	/**
	 * Setzt den Zug des Spielers 2
	 * @param zug, den zu setzenden Zug
	 * @return
	 *  0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug ausserhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 */
	public int setZugSpieler2(int zug) {
		return setZug(zug, SPIELER2);
	}
	
	/**
	 * Ermittelt die Nummer des Spielers der gewonnen hat
	 * @return
	 * 0 derzeit hat noch niemand gewonnen
	 * SPIELER1 oder SPIELER2
	 */
	public int getGewonnen() {
		int ret = 0;
		int feld;
		int counter = 0;
		int counter2 = 0;
		//Geht für player alle Gewinnkombinationen durch
		int player = SPIELER1;
		int n = 0;
		while (n < 2) {
			//Geht alle waagrechte Linien durch
			for (int i = 0; i < spielfeld.length; i++) {
				for (int j = 0; j < spielfeld.length; j++) {
					feld = getSpielfeld(i, j);
					if (feld == player) {
						counter++;
					}
				}
				if (counter > counter2) {
					counter2 = counter;
				}
				counter = 0;
			}
			if (counter2 == getFeldgroesse()) {
				ret =  player;
			}
			//Geht alle senkrechten Linien durch
			counter2 = 0;
			if (ret == 0) {
				for (int i = 0; i < spielfeld.length; i++) {
					for (int j = 0; j < spielfeld.length; j++) {
						feld = getSpielfeld(j, i);
						if (feld == player) {
							counter++;
						}
					}
					if (counter > counter2) {
						counter2 = counter;
					}
					counter = 0;
				}
				if (counter2 == getFeldgroesse()) {
					ret = player;
				}
				//geht die 1. Diagonale durch
				counter2 = 0;
				if (ret == 0) {
					int i = 0;
					int j = 0;
					while (i < getFeldgroesse()) {
						feld = getSpielfeld(i, j);
						if (feld == player) {
							counter++;
						}
						i++;
						j++;
					}
					if (counter == getFeldgroesse()) {
						ret = player;
					}
					//geht die 2. Diagonale durch
					counter = 0;
					if (ret == 0) {
						i = 0;
						j = getFeldgroesse()-1;
						while (i < getFeldgroesse()) {
							feld = getSpielfeld(i, j);
							if (feld == player) {
								counter++;
							}
							i++;
							j--;
						}
						if (counter == getFeldgroesse()) {
							ret = player;
						}
						counter = 0;
					}
				}
			}
			//player wird gewechselt
			if (ret == 0) {
				player = SPIELER2;
				n++;
			}
			else {
				//schleifenabbruch
				n = 2;
			}
		}
		//return
		return ret;
	}
	
	/**
	 * Ermittelt ob einer der Spieler das Spiel noch gewinnen kann
	 * @return true falls das Spiel noch gewonnen werden kann
	 */
	public boolean getEinerKannGewinnen() {
		
		//Intialisierung
		int felder_player1 = 0;
		int felder_player2 = 0;
		int currentplayer;
		int otherplayer;
		boolean ret = false;
		int counter = 0;
		int feld;
		//der aktuelle Spieler wird bestimmt
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				feld = getSpielfeld(i, j);
				if (feld == SPIELER1) {
					felder_player1++;
				}
				if (feld == SPIELER2) {
					felder_player2++;
				}
			}
		}
		if (felder_player1 == felder_player2) {
			currentplayer = SPIELER1;
			otherplayer = SPIELER2;
		}
		else {
			currentplayer = SPIELER2; 
			otherplayer = SPIELER1;
		}
		//Überprüfung ob noch freie Waagrechten für aktuellenSpieler verfügbar sind
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				feld = getSpielfeld(i, j);
				if (feld == otherplayer) {
					counter++;
				}
			}
			if (counter == 0) {
				ret = true;
				break;
			}
			counter = 0;
		}
		if (!ret) {
			//Überprüfung ob noch freie Senkrechten für aktuellenSpieler verfügbar sind
			for (int i = 0; i < spielfeld.length; i++) {
				for (int j = 0; j < spielfeld.length; j++) {
					feld = getSpielfeld(j, i);
					if (feld == otherplayer) {
						counter++;
					}
				}
				if (counter == 0) {
					ret = true;
					break;
				}
				counter = 0; 
			}
			if (!ret) {
				//Überprüfung ob die 1. Diagonale noch gewinnbar ist
				int i = 0;
				int j = 0;
				while (i < getFeldgroesse()) {
					feld = getSpielfeld(i, j);
					if (feld == otherplayer) {
						counter++;
					}
					i++;
					j++;
				}
				if (counter == 0) {
					ret = true;
				}
				counter = 0;
				if (!ret) {
					//Überprüfung ob die 2. Diagonale noch gewinnbar ist
					i = 0;
					j = getFeldgroesse()-1;
					while (i < getFeldgroesse()) {
						feld = getSpielfeld(i, j);
						if (feld == otherplayer) {
							counter++;
						}
						i++;
						j--;
					}
					if (counter == 0) {
						ret = true;
					}
					counter = 0;
					int spacecounter = 0;
					if (!ret) {
						//Überprüfung der Gewinnchancen des aktuellenSpielers in den Waagrechten
						for (i = 0; i < spielfeld.length; i++) {
							for (j = 0; j < spielfeld.length; j++) {
								feld = getSpielfeld(i, j);
								if (feld >= 0) {
									spacecounter++;
								}
								if (feld == otherplayer) {
									counter++;
								}
							}
							if (counter > (getFeldgroesse()/2) && counter + spacecounter == getFeldgroesse()) {
								ret = true;
								break;
							}
							counter = 0;
							spacecounter = 0;
						}
						//Überprüfung der Gewinnchancen des aktuellenSpielers in den Senkrechten
						for (i = 0; i < spielfeld.length; i++) {
							for (j = 0; j < spielfeld.length; j++) {
								feld = getSpielfeld(j, i);
								if (feld >= 0) {
									spacecounter++;
								}
								if (feld == otherplayer) {
									counter++;
								}
							}
							if (counter > (getFeldgroesse()/2) && counter + spacecounter == getFeldgroesse()) {
								ret = true;
								break;
							}
							counter = 0;
							spacecounter = 0;
						}
						//Überprüfung der Gewinnchancen des aktuellenSpielers in der 1. Diagonale
						i = 0;
						j = 0;
						while (i < getFeldgroesse()) {
							feld = getSpielfeld(i, j);
							if (feld >= 0) {
								spacecounter++;
							}
							if (feld == otherplayer) {
								counter++;
							}
							i++;
							j++;
						}
						if (counter > (getFeldgroesse()/2) && counter + spacecounter == getFeldgroesse()) {
							ret = true;
						}
						counter = 0;
						spacecounter = 0;
						//Überprüfung der Gewinnchancen des aktuellenSpielers in der 2. Diagonale
						i = 0;
						j = getFeldgroesse()-1;
						while (i < getFeldgroesse()) {
							feld = getSpielfeld(i, j);
							if (feld >= 0) {
								spacecounter++;
							}
							if (feld == otherplayer) {
								counter++;
							}
							i++;
							j++;
						}
						if (counter > (getFeldgroesse()/2) && counter + spacecounter == getFeldgroesse()) {
							ret = true;
						}
					}
				}
			}
		}
		//return
		return ret;
	}
}