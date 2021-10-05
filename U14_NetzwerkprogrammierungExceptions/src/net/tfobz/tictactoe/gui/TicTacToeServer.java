package net.tfobz.tictactoe.gui;
import net.tfobz.tictactoe.*;
import java.net.*;
import java.io.*;

/**
 * TicTacToeServer erbt von TicTacToe und realsiert einen Server zum TicTacToe-Spielen
 * Das Spielfeld wird mit einer GUI dargestellt
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
		TicTacToeServer tictactoeServer = null;
		TicTacToeJFrame tictactoeFenster = null;
		try {
			//TicTacToeServer Objekt wird erstellt
			tictactoeServer = new TicTacToeServer(FELDGROESSE, PORT);
			//GUI-Fenster wird erstellt
			tictactoeFenster = new TicTacToeJFrame("TicTacToeServer", tictactoeServer);
			//Solange das Spiel noch von einem Spieler gewonnen werden kann
			while (tictactoeServer.getEinerKannGewinnen() && tictactoeServer.getGewonnen() == 0) {
				boolean loop = true;
				tictactoeFenster.setStatusleistentext("Warten auf den Zug des Gegners");
				try {
					//Gegner-Zug wird geholt. Wenn rueckgabe gleich -3 ist, dann ist ein Fehler mit dem ClientSocket passiert
					if (tictactoeServer.getGegnerZug() == -3) {
						tictactoeFenster.setStatusleistentext("ClientSocket exsistiert bereits");
						System.out.println("Clientsockt exsistiert bereits");
						if (tictactoeServer.clientSocket != null) {
							tictactoeServer.close();
						}
						else {
							tictactoeServer.server.close();
						}
						System.exit(-1);
					}
					tictactoeFenster.repaint();
					//Überprüfung auf Unentschieden oder Sieg
					if (tictactoeServer.getGewonnen() != 0 || !tictactoeServer.getEinerKannGewinnen()) {
						break;
					}
					int zug = 0;
					tictactoeFenster.setStatusleistentext("Bitte ihren Zug eingeben!");
					while (loop) {
						//zug wird eingelesen
						zug = tictactoeFenster.getGewaehlteFeldnummer();
						//Der Zug wird gesetzt
						int ret = tictactoeServer.setMeinZug(zug);
						//Rückgabe der SetZugMethode wird analysiert
						switch(ret) {
						//Zug wurde korrekt gesetzt
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
								tictactoeFenster.setStatusleistentext("Clientsocket nicht vorhanden");
								System.out.println("Clientsocket nicht vorhanden");
								System.exit(-1);
							}
						}
						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//Spieler1 hat gewonnen
			if (tictactoeServer.getGewonnen() == tictactoeServer.SPIELER1) {
				tictactoeFenster.setStatusleistentext("Der Gegner hat gewonnen!");
			} else {
				//Spieler2 hat gewonnen
				if (tictactoeServer.getGewonnen() == tictactoeServer.SPIELER2) {
					tictactoeFenster.setStatusleistentext("Sie haben gewonnen!");
				} else {
					//Unentschieden
					if (!tictactoeServer.getEinerKannGewinnen()) {
						tictactoeFenster.setStatusleistentext("Unentschieden!");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				tictactoeServer.close();
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
