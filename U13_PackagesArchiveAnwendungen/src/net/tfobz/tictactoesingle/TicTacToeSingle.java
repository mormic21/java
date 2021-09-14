package net.tfobz.tictactoesingle;

import net.tfobz.tictactoe.*;

public class TicTacToeSingle {

	public static void main(String[] args) {
		System.out.println("T i c T a c T o e");
		System.out.println("=================");
		char nochmal = 'n';
		int ret = 0;
		do {
			TicTacToe ttt = new TicTacToe(3);
			while (ttt.getEinerKannGewinnen()) {
				boolean loop = true;
				System.out.println(ttt.toString());
				while (loop) {
					System.out.print("1. Spieler: Ihr Zug: ");
					try {
						ret = ttt.setZugSpieler1(new java.util.Scanner(System.in).nextInt());
					} catch (Exception e) {
						System.out.println("Bitte geben Sie eine gültige Zahl ein!");
						continue;
					}
					
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
				if (ttt.getGewonnen() != 0 || !ttt.getEinerKannGewinnen()) {
					break;
				}
				System.out.println(ttt.toString());
				while (loop) {
					System.out.print("2. Spieler: Ihr Zug: ");
					try {
						ret = ttt.setZugSpieler2(new java.util.Scanner(System.in).nextInt());
					} catch (Exception e) {
						System.out.println("Bitte geben Sie eine gültige Zahl ein!");
						continue;
					}
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
				if (ttt.getGewonnen() != 0) {
					break;
				}
			}
			if (ttt.getGewonnen() == ttt.SPIELER1) {
				System.out.println("Spieler 1 hat gewonnen!!!");
			} else {
				if (ttt.getGewonnen() == ttt.SPIELER2) {
					System.out.println("Spieler 2 hat gewonnen!!!");
				} else {
					if (!ttt.getEinerKannGewinnen()) {
						System.out.println("Unentschieden!!!");
					}
				}
			}
			System.out.print("Noch ein Spiel (j/n)? ");
			nochmal = new java.util.Scanner(System.in).next().charAt(0);
		} while (Character.toLowerCase(nochmal) == 'j');
	}

}
