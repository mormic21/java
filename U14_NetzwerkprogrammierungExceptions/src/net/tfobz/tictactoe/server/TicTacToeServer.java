package net.tfobz.tictactoe.server;
import net.tfobz.tictactoe.*;
import java.net.*;
import java.io.*;

/**
 * TicTacToeServer erbt von TicTacToe und realsiert einen Server zum TicTacToe-Spielen
 * @author Michael Morandell
 *
 */
public class TicTacToeServer extends TicTacToe{
	//Die vorgegebene Feldgröße des Spielfeldes
	private static final int FELDGROESSE = 3;
	//Port auf welchem der Server läuft
	private static final int PORT = 65000;
	//Über dieses Objekt werden alle Clientabfragen abgearbeitet. Dieses Objekt stellt den ServerSocket dar
	private ServerSocket server;
	/**
	 * Clientsocket über welchen das Empfangen eines Zuges und das Senden des nächsten Zuges abgewickelt wird. 
	 * Der Socket stirbt, wenn das Empfangen und Senden abgewickelt wurde. Zuerst muss empfangen, dann gesendet werden
	 */
	private Socket clientSocket;
	
	/**
	 * Parameterbehafteter Konstruktor, der das Spielfeld anlegt und den ServerSocket erstellt
	 * @param feldgroesse, des Spielfeldes
	 * @param port, auf dem der Server läuft
	 * @throws java.io.IOException
	 */
	public TicTacToeServer(int feldgroesse, int port) throws IOException {
		super(feldgroesse);
		//ServerSocket wird erstellt
		this.server = new ServerSocket(port);
	}
	
	/**
	 * Legt zuerst einen ServerSocket an, gibt das Spielfeld aus und wartet auf den Zug des Clients. 
	 * Nachdem dieser empfangen wurde, wird der Zug des Servers gesetzt und an den Client zurück geschickt. 
	 * Dies wird solange gemacht, bis einer der Spieler gewonnen hat, oder erkannt wurde, 
	 * dass niemand mehr das Spiel gewinnen kann. In diesen Fällen wird das Programm beendet.
	 * @param args
	 */
	public static void main(String[] args) {
		TicTacToeServer tServer = null;
		try {
			//TicTacToeServer Objekt wird erstellt
			tServer = new TicTacToeServer(FELDGROESSE, PORT);
			System.out.println("T i c T a c T o e - S e r v e r");
			System.out.println("===============================");
			//Solange das Spiel noch von einem Spieler gewonnen werden kann
			while (tServer.getEinerKannGewinnen() && tServer.getGewonnen() == 0) {
				boolean loop = true;
				System.out.println(tServer.toString());
				System.out.println("Warten auf den Zug des Gegners ...");
				try {
					//Gegner-Zug wird geholt. Wenn rueckgabe gleich -3 ist, dann ist ein Fehler mit dem ClientSocket passiert
					if (tServer.getGegnerZug() == -3) {
						System.out.println("ClientSocket exsistiert bereits");
						if (tServer.clientSocket != null) {
							tServer.close();
						}
						else {
							tServer.server.close();
						}
						System.exit(-1);
					}
					//Ausgabe des Spielfeldes
					System.out.println(tServer.toString());
					//Überprüfung auf Unentschieden oder Sieg
					if (tServer.getGewonnen() != 0 || !tServer.getEinerKannGewinnen()) {
						break;
					}
					int zug = 0;
					while (loop) {
						try {
							//Eingabe des Zuges ins Terminal durch den Spieler
							zug = tServer.readInt("Ihr Zug: ");
						} catch (Exception e) {
							//Wenn keine gültige Int-Zahl eigegeben wurde (z.B. ein Char)
							System.out.println("Bitte geben Sie eine gültige Zahl ein!");
							continue;
						}
						int ret = 0;
						try {
							//Der eingegebene Zug wird gesetzt
							ret = tServer.setMeinZug(zug);
						} catch (IOException e) {
							//bei Fehler: ist die Verbindung zum Client abgebrochen. Das Programm wird beendet
							System.out.println("Verbindung zum ClientSocket verloren");
							if (tServer.clientSocket != null) {
								tServer.close();
							}
							else {
								tServer.server.close();
							}
							System.exit(-1);
						}
						//Rückgabe der SetZugMethode wird analysiert
						switch(ret) {
							//Zug wurde korrekt gesetzt. Schleife wird abgebrochen
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
							case -3: {
								System.out.println("Clientsocket nicht vorhanden");
								break;
							}
						}
						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//Spieler1 hat gewonnen
			if (tServer.getGewonnen() == tServer.SPIELER1) {
				System.out.println("Der Gegner hat gewonnen!");
			} else {
				//Spieler2 hat gewonnen
				if (tServer.getGewonnen() == tServer.SPIELER2) {
					System.out.println("Sie haben gewonnen!");
				} else {
					//Unentschieden
					if (!tServer.getEinerKannGewinnen()) {
						System.out.println("Unentschieden!");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				tServer.close();
			} catch (Exception e) {;}
		}
	}
	
	/**
	 * Schließt den internen ServerSocket und ClientSocket
	 * @throws java.io.IOException
	 */
	public void close() throws java.io.IOException {
		server.close();
		clientSocket.close();
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
	 * Wartet dass der Client die Verbindung mit dem Server aufnimmt und einen Zug sendet. 
	 * Wenn der Zug gesendet wurde, wird der ClientSocket nicht geschlossen, denn der 
	 * Server analysiert den Zug, trägt ihn ins Spielfeld ein und schickt seinen Zug über denselben 
	 * ClientSocket zurück zum Client
	 * @return
	 * 0 falls erfolgreich empfangen oder Zug 0 geschickt
	 * -1 falls der empfangene Zug außerhalb des Spielfeldes liegt
	 * -2 falls der empfangene Zug bereits gesetzt wurde
	 * -3 falls Clientsocket bereits existiert
	 * @throws java.io.IOException - falls beim Erstellen des Clientsockets ein Fehler aufgetreten ist
	 */
	public int getGegnerZug() throws java.io.IOException {
		int ret = -3;
		//wenn client geschlossen ist
		if (this.clientSocket == null || this.clientSocket.isClosed()) {
			//Warten auf Verbindungsanfrage des Clients
			this.clientSocket = this.server.accept();
			//Input-Stream wird geholt
			InputStream in = this.clientSocket.getInputStream();
			//Einlesen des Zuges des Clients
			int zug = (byte)in.read();
			ret = this.setZugSpieler1(zug);
		}
		return ret;
	}
	
	/**
	 * Es wird über den bereits vorhandenen ClientSocket der Zug des Servers 
	 * an den Client geschickt. Dabei muss der ClientSocket existieren. 
	 * Nach dem Schicken wird der ClientSocket geschlossen
	 * @param zug - der zu schickende Zug
	 * @return
	 * 0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug außerhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls kein ClientSocket vorhanden ist
	 * @throws java.io.IOException - falls beim Senden ein Fehler aufgetreten ist
	 */
	public int setMeinZug(int zug) throws java.io.IOException {
		int ret = -3;
		//Wenn der ClientSocket noch verbunden ist
		if (this.clientSocket.isConnected()) {
			//Outputstream wird geholt
			OutputStream out = this.clientSocket.getOutputStream();
			ret = this.setZugSpieler2(zug);
			/*
			 * Wenn der Zug im Spielfeld des Servers gesetzt werden kann, 
			 * so wird der Zug dem Client gesendet und das Socket wird geschlossen
			 */
			if (ret == 0) {
				out.write(zug);
				this.clientSocket.close();
			}
		}
		return ret;
	}
}
