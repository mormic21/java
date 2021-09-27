package net.tfobz.tictactoe.client;

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
	private static final int PORT = 65535;
	/**
	 * Variable über welche der TicTacToeClient verwaltet wird. 
	 * Das Objekt wird durch die Methode setMeinZug erstellt, in der Methode getGegnerZug weiter 
	 * verwendet und dann geschlossen
	 */
	private Socket client;
	
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
			System.exit(1);
		}
		TicTacToeClient tClient = null;
		try {
			tClient = new TicTacToeClient(FELDGROESSE);
			System.out.println("T i c T a c T o e - C l i e n t");
			System.out.println("===============================");
			while (tClient.getEinerKannGewinnen() && tClient.getGewonnen() == 0) {
				boolean loop = true;
				System.out.println(tClient.toString());
				try {
					int zug = -1;
					while (loop) {
						try {
							zug = tClient.readInt("Ihr Zug: ");
						} catch (Exception e) {
							System.out.println("Bitte geben Sie eine gültige Zahl ein!");
							continue;
						}
						int ret = tClient.setMeinZug(zug);
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
					if (tClient.getGewonnen() != 0 || !tClient.getEinerKannGewinnen()) {
						break;
					}
					System.out.println(tClient.toString());
					System.out.println("Warten auf den Zug des Gegners...");
					tClient.getGegnerZug();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						tClient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			//Spieler1 hat gewonnen
			if (tClient.getGewonnen() == tClient.SPIELER1) {
				System.out.println("Der Gegner hat gewonnen!");
			} else {
				//Spieler2 hat gewonnen
				if (tClient.getGewonnen() == tClient.SPIELER2) {
					System.out.println("Sie haben gewonnen!");
				} else {
					//Unentschieden
					if (!tClient.getEinerKannGewinnen()) {
						System.out.println("Unentschieden!");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				tClient.close();
			} catch (IOException e) {
				e.printStackTrace();
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
		if (zug == 0) {
			if (this.client == null) {
				this.client = new Socket(ipAdresse, PORT);
				OutputStream out = this.client.getOutputStream();
				out.write(zug);
			}
			else {
				ret = 3;
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
		if (this.client != null) {
			InputStream in = this.client.getInputStream();
			int zug = (byte)in.read();
			ret = this.setZugSpieler2(zug);
			if (ret == 0) {
				this.client.close();
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
		client.close();
	}



	
	
	
	
	
//	private static final String HOST = "localhost";
//	private static final int PORT = 65535;
//
//	public static void main(String[] args) {
//		Socket client = null;
//		try {
//			client = new Socket(HOST, PORT);
//			InputStream in = client.getInputStream();
//			OutputStream out = client.getOutputStream();
//			out.write(4);
//			out.write(9);
//			int ergebnis = (byte) in.read();
//			System.out.println(ergebnis);
//		} catch (UnknownHostException e) {
//			behandleException(e);
//		} catch (IOException e) {
//			behandleException(e);
//		} finally {
//			try {
//				client.close();
//			} catch (Exception e) {
//				;
//			}
//		}
//	}
//
//	private static void behandleException(Exception e) {
//		System.out.println("Exception Objekt: " + e.getClass().getName());
//		System.out.println("Fehlermeldung: " + e.getMessage());
//	}
}
