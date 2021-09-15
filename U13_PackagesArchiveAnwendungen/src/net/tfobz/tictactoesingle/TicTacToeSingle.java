package net.tfobz.tictactoesingle;
import net.tfobz.tictactoe.*;

/**
 * Main-Klasse für TicTacToe.java
 * @author Michael Morandell
 *
 */
public class TicTacToeSingle {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("T i c T a c T o e");
		System.out.println("=================");
		char nochmal = 'n';
		boolean loop = true;
		int ret = 0;
		do {
			//neues TicTacToe feld mit groesse 3
			TicTacToe ttt = new TicTacToe(3);
			//Überprüfung auf Unentschieden
			while (ttt.getEinerKannGewinnen()) {
				loop = true;
				//Ausgabe des aktuellen Spielfeldes
				System.out.println(ttt.toString());
				//Eingabe des Zuges von Spieler 1
				while (loop) {
					System.out.print("1. Spieler: Ihr Zug: ");
					try {
						ret = ttt.setZugSpieler1(new java.util.Scanner(System.in).nextInt());
					} catch (Exception e) {
						System.out.println("Bitte geben Sie eine gültige Zahl ein!");
						continue;
					}
					//Rückgabe der SetZugMethode wird analysiert
					switch(ret) {
						case 0: {
							loop = false;
							break;
						}
						case -1: {
							System.out.println("Der angegebene Zug liegt auserhalb des Spielfeldes!");
							break;
						}
						case -2: {
							System.out.println("Der angegebene Zug wurde bereits gesetzt!");
							break;
						}
					}
				}
				loop = true;
				//Überprüfung auf Unentschieden oder Sieg
				if (ttt.getGewonnen() != 0 || !ttt.getEinerKannGewinnen()) {
					break;
				}
				//Ausgabe des aktuellen Spielfeldes
				System.out.println(ttt.toString());
				//Eingabe des Zugs des 2. Spielers
				while (loop) {
					System.out.print("2. Spieler: Ihr Zug: ");
					try {
						ret = ttt.setZugSpieler2(new java.util.Scanner(System.in).nextInt());
					} catch (Exception e) {
						System.out.println("Bitte geben Sie eine gültige Zahl ein!");
						continue;
					}
					//Rückgabe der SetZugMethode wird analysiert
					switch(ret) {
						case 0: {
							loop = false;
							break;
						}
						case -1: {
							System.out.println("Der angegebene Zug liegt auserhalb des Spielfeldes!");
							break;
						}
						case -2: {
							System.out.println("Der angegebene Zug wurde bereits gesetzt!");
							break;
						}
					}
				}
				//Überprüfung auf Sieg
				if (ttt.getGewonnen() != 0) {
					break;
				}
			}
			//Spieler1 hat gewonnen
			if (ttt.getGewonnen() == ttt.SPIELER1) {
				System.out.println("Spieler 1 hat gewonnen!!!");
			} else {
				//Spieler2 hat gewonnen
				if (ttt.getGewonnen() == ttt.SPIELER2) {
					System.out.println("Spieler 2 hat gewonnen!!!");
				} else {
					//Unentschieden
					if (!ttt.getEinerKannGewinnen()) {
						System.out.println("Unentschieden!!!");
					}
				}
			}
			//Benutzereingabe für ein weiteres Spiel
			loop = true;
			while (loop) {
				System.out.print("Noch ein Spiel (j/n)? ");
				nochmal = new java.util.Scanner(System.in).next().charAt(0);
				nochmal = Character.toLowerCase(nochmal);
				if (nochmal == 'j' || nochmal == 'n') {
					loop = false;
				}
				else {
					System.out.println("Bitte 'j' oder 'n' eingeben!");
				}
			}
			// wenn j (ja) gewählt wurde, wird die Schleife wiederholt und ein neues Spiel gestartet
		} while (nochmal == 'j');
	}

}
