package net.tfobz.tictactoe.gui;

import java.net.*;
import java.io.*;
import net.tfobz.tictactoe.*;
import net.tfobz.tictactoe.server.TicTacToeServer;

public class TicTacToeClient extends TicTacToe{
	//Die vorgegebene Feldgröße des Spielfeldes
	private static final int FELDGROESSE = 3;
	//Die IP-Adresse an welcher der TicTacToeServer läuft
	private static String ipAdresse;
	//Port auf welchem der Server läuft
	private static final int PORT = 65000;
	/**
	 * Variable über welche der TicTacToeClient verwaltet wird. 
	 * Das Objekt wird durch die Methode setMeinZug erstellt, in der Methode getGegnerZug weiter 
	 * verwendet und dann geschlossen
	 */
	private Socket client;
	
	/**
	 * Parameterbehafteter Konstruktor, der das Spielfeld anlegt
	 * @param feldgroesse - des Spielfeldes
	 */
	public TicTacToeClient(int feldgroesse) {
		super(feldgroesse);
	}
	
	/**
	 * Im ersten Parameter wird die IP-Adresse des Servers übergeben. Ist dies nicht der Fall, so bricht das Programm ab
	 * @param args - in args[0] muss die IP-Adresse des TicTacToeServers übergeben werden
	 */
	public static void main(String[] args) {
		if(args == null || args.length != 1) {
			System.out.println("Bitte als ersten Parameter die IP-Adresse des Servers übergeben!");
			System.exit(-1);
		}
		TicTacToeClient tictactoeClient = null;
		TicTacToeJFrame tictactoeFenster = null;
		tictactoeClient = new TicTacToeClient(FELDGROESSE);
		tictactoeClient.ipAdresse = args[0];
		tictactoeFenster = new TicTacToeJFrame("TicTacToeClient", tictactoeClient);
		while (tictactoeClient.getEinerKannGewinnen() && tictactoeClient.getGewonnen() == 0) {
			boolean loop = true;
			try {
				int zug = -1;
				tictactoeFenster.setStatusleistentext("Bitte geben sie ihren Zug ein!");
				while (loop) {
					zug = tictactoeFenster.getGewaehlteFeldnummer();
					int ret = tictactoeClient.setMeinZug(zug);
					//Rückgabe der SetZugMethode wird analysiert
					switch(ret) {
						case 0: {
							loop = false;
							tictactoeFenster.repaint();
							break;
						}
						case -2: {
							tictactoeFenster.setStatusleistentext("Der angegebene Zug wurde bereits gesetzt!");
							break;
						}
						case -3: {
							tictactoeFenster.setStatusleistentext("Clientsocket exsistiert bereits");
							System.out.println("Clientsocket exsistiert bereits");
							System.exit(-1);
						}
					}
				}
				if (tictactoeClient.getGewonnen() != 0 || !tictactoeClient.getEinerKannGewinnen()) {
					break;
				}
				tictactoeFenster.setStatusleistentext("Warten auf den Zug des Gegners");
				if (tictactoeClient.getGegnerZug() == -3) {
					tictactoeFenster.setStatusleistentext("Kein ClientSocket vorhanden");
					System.out.println("Kein ClientSocket vorhanden");
					System.exit(-1);
				}
				tictactoeFenster.repaint();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					tictactoeClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//Spieler1 hat gewonnen
		if (tictactoeClient.getGewonnen() == tictactoeClient.SPIELER2) {
			tictactoeFenster.setStatusleistentext("Der Gegner hat gewonnen!");
		} else {
			//Spieler2 hat gewonnen
			if (tictactoeClient.getGewonnen() == tictactoeClient.SPIELER1) {
				tictactoeFenster.setStatusleistentext("Sie haben gewonnen!");
			} else {
				//Unentschieden
				if (!tictactoeClient.getEinerKannGewinnen()) {
					tictactoeFenster.setStatusleistentext("Unentschieden!");
				}
			}
		}
	}
	
	/**
	 * Setzt den Zug im Spielfeld. Wenn der Zug korrekt gesetzt werden konnte, 
	 * dann nimmt die Methode die Verbindung mit dem Server auf und sendet den Zug. 
	 * Wenn der Zug gesendet wurde, wird der ClientSocket nicht geschlossen, denn der Server 
	 * analysiert den Zug und schickt seinen Zug über denselben Socket zurück zum Client
	 * @param zug - der zu sendende Zug
	 * @return
	 * 0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls Clientsocket bereits existiert
	 * @throws java.io.IOException
	 * @throws java.net.UnknownHostException, falls beim Erstellen des ClientSockets ein Fehler aufgetreten ist
	 */
	public int setMeinZug(int zug) throws java.io.IOException, java.net.UnknownHostException {
		int ret = this.setZugSpieler1(zug);
		if (ret == 0) {
			if (this.client == null || this.client.isClosed()) {
				this.client = new Socket(ipAdresse, PORT);
				OutputStream out = this.client.getOutputStream();
				out.write(zug);
			}
			else {
				ret = -3;
			}
		}
		return ret;
	}
	
	
	/**
	 * Es wird über den bereits vorhandenen Socket auf den Zug des Servers gewartet. 
	 * Dabei muss der Socket existieren. Nach dem Empfangen wird der Socket geschlossen.
	 * Weiters wird der empfangene Zug ins Spielfeld eingetragen
	 * @return
	 * 0 oder größer falls Zug erfolgreich geholt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls kein Socket vorhanden ist
	 * @throws java.io.IOException - falls beim Empfangen ein Fehler aufgetreten ist
	 */
	public int getGegnerZug() throws java.io.IOException {
		int ret = -3;
		if (this.client != null && !this.client.isClosed()) {
			InputStream in = this.client.getInputStream();
			int zug = (byte)in.read();
			ret = this.setZugSpieler2(zug);
			if (ret == 0) {
				this.close();
			}
		}
		return ret;
	}
	
	/**
	 * readint
	 * @param text
	 * @return
	 */
	private static int readInt(String text) {
		System.out.print(text);
		return (new java.util.Scanner(System.in).nextInt());
	}
	
	/**
	 * Schließt den ClientSocket
	 * @throws java.io.IOException
	 */
	public void close() throws java.io.IOException {
		this.client.close();
	}
}
