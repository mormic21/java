package net.tfobz.tictactoesingle;
import net.tfobz.tictactoe.*;

public class TicTacToeSingle {

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe(4);
		System.out.println("T i c T a c T o e");
		System.out.println("=================");
		while(ttt.getGewonnen() == 0) {
			System.out.println(ttt.toString());
			System.out.print("1. Spieler: Ihr Zug: ");
			ttt.setZugSpieler1(new java.util.Scanner(System.in).nextInt());
		    if (ttt.getGewonnen() != 0) {
		    	break;
		    }
		    System.out.println(ttt.toString());
			System.out.print("2. Spieler: Ihr Zug: ");
			ttt.setZugSpieler2(new java.util.Scanner(System.in).nextInt());
		}
		if (ttt.getGewonnen() == ttt.SPIELER1) {
			System.out.println("Spieler 1 hat gewonnen!!!");
		}
		else {
			if (ttt.getGewonnen() == ttt.SPIELER2){
				System.out.println("Spieler 2 hat gewonnen!!!");
			}
			else {
				System.out.println("Keiner hat gewonnen!!!");
			}
		}
	}

}
