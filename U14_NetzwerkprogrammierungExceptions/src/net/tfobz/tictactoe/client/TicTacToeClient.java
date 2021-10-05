package net.tfobz.tictactoe.client;

import java.net.*;
import java.io.*;
import net.tfobz.tictactoe.*;

/**
 * TicTacToeClient erbt von TicTacToe und realsiert einen Client zum TicTacToe spielen
 * @author Michael Morandell
 *
 */
public class TicTacToeClient extends TicTacToe{
	//Die vorgegebene Feldgr��e des Spielfeldes
	private static final int FELDGROESSE = 3;
	//Die IP-Adresse an welcher der TicTacToeServer l�uft
	private static String ipAdresse;
	//Port auf welchem der Server l�uft
	private static final int PORT = 65000;
	/**
	 * Variable �ber welche der TicTacToeClient verwaltet wird. 
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
	 * Main
	 * Im ersten Parameter wird die IP-Adresse des Servers �bergeben. Ist dies nicht der Fall, so bricht das Programm ab
	 * @param args - in args[0] muss die IP-Adresse des TicTacToeServers �bergeben werden
	 */
	public static void main(String[] args) {
		//Wenn die IP-Adresse nicht als erstes Argument �bergeben wird, wird der Client beendet
		if(args == null || args.length != 1) {
			System.out.println("Bitte als ersten Parameter die IP-Adresse des Servers �bergeben!");
			System.exit(1);
		}
		//TicTacToeClient-Objekt wird erstellt
		TicTacToeClient tClient = null;
		tClient = new TicTacToeClient(FELDGROESSE);
		tClient.ipAdresse = args[0];
		System.out.println("T i c T a c T o e - C l i e n t");
		System.out.println("===============================");
		//Solange das Spiel noch gewonnen werden kann
		while (tClient.getEinerKannGewinnen() && tClient.getGewonnen() == 0) {
			boolean loop = true;
			//Ausgabe des Spielfeldes
			System.out.println(tClient.toString());
			try {
				int zug = 0;
				while (loop) {
					try {
						//Zug wird aus dem Terminal eingelesen -> Benutzereingabe
						zug = tClient.readInt("Ihr Zug: ");
					} catch (Exception e) {
						//Wenn keie g�ltige INT-Zahl eingegeben wurde -> Eingabe wird wiederholt
						System.out.println("Bitte geben Sie eine g�ltige Zahl ein!");
						continue;
					}
					int ret = 0;
					try {
						//Der Eingegebene Zug wird gesetzt
						ret = tClient.setMeinZug(zug);
					} catch (IOException e) {
						//Wenn IOException geworfen wird, so ist die Verbindung zum Server unterbrochen. Der Client wird beendet
						System.out.println("Verbindung zum ServerSocket verloren");
						if (tClient.client != null) {
							tClient.close();
						}
						System.exit(-1);
					}
					//R�ckgabe der SetZugMethode wird analysiert
					switch(ret) {
						//Zug konnte korrekt gesetzt werden
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
							System.out.println("Clientsocket exsistiert bereits");
							break;
						}
					}
				}
				//�berpr�fung auf Gewinn oder Unentschieden
				if (tClient.getGewonnen() != 0 || !tClient.getEinerKannGewinnen()) {
					break;
				}
				//Ausgabe des Spielfeldes
				System.out.println(tClient.toString());
				System.out.println("Warten auf den Zug des Gegners...");
				//Zug des Servers wird geholt. Wenn die R�ckgabe -3 ist, so ist ein Fehler mit dem ClientSocket passiert
				if (tClient.getGegnerZug() == -3) {
					System.out.println("Kein ClientSocket vorhanden!");
				}
				//unknownHostException und IOException werden aufgefangen und gehandelt
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				//zum schluss wird der client geschlossen
			} finally {
				try {
					tClient.close();
				} catch (Exception e) {;}
			}
		}
		//Spieler1 hat gewonnen
		if (tClient.getGewonnen() == tClient.SPIELER2) {
			System.out.println("Der Gegner hat gewonnen!");
		} else {
			//Spieler2 hat gewonnen
			if (tClient.getGewonnen() == tClient.SPIELER1) {
				System.out.println("Sie haben gewonnen!");
			} else {
				//Unentschieden
				if (!tClient.getEinerKannGewinnen()) {
					System.out.println("Unentschieden!");
				}
			}
		}
	}
	
	/**
	 * Setzt den Zug im Spielfeld. Wenn der Zug korrekt gesetzt werden konnte, 
	 * dann nimmt die Methode die Verbindung mit dem Server auf und sendet den Zug. 
	 * Wenn der Zug gesendet wurde, wird der ClientSocket nicht geschlossen, denn der Server 
	 * analysiert den Zug und schickt seinen Zug �ber denselben Socket zur�ck zum Client
	 * @param zug - der zu sendende Zug
	 * @return
	 * 0 falls Zug erfolgreich gesetzt werden konnte
	 * -1 falls der Zug au�erhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls Clientsocket bereits existiert
	 * @throws java.io.IOException
	 * @throws java.net.UnknownHostException, falls beim Erstellen des ClientSockets ein Fehler aufgetreten ist
	 */
	public int setMeinZug(int zug) throws java.io.IOException, java.net.UnknownHostException {
		//Zug wird versucht zu setzten
		int ret = this.setZugSpieler1(zug);
		//Wenn das Setzen erfolgreich war
		if (ret == 0) {
			if (this.client == null || this.client.isClosed()) {
				//verbindung zum Server wird aufgenommen
				this.client = new Socket(ipAdresse, PORT);
				OutputStream out = this.client.getOutputStream();
				//Der Zug wird dem Server geschickt
				out.write(zug);
			} else {
				ret = -3;
			}
		}
		return ret;
	}
	
	
	/**
	 * Es wird �ber den bereits vorhandenen Socket auf den Zug des Servers gewartet. 
	 * Dabei muss der Socket existieren. Nach dem Empfangen wird der Socket geschlossen.
	 * Weiters wird der empfangene Zug ins Spielfeld eingetragen
	 * @return
	 * 0 oder gr��er falls Zug erfolgreich geholt werden konnte
	 * -1 falls der Zug au�erhalb des Spielfeldes liegt
	 * -2 falls der Zug bereits gesetzt wurde
	 * -3 falls kein Socket vorhanden ist
	 * @throws java.io.IOException - falls beim Empfangen ein Fehler aufgetreten ist
	 */
	public int getGegnerZug() throws java.io.IOException {
		int ret = -3;
		//Wenn Socket-Verbindung noch offen ist
		if (this.client != null && !this.client.isClosed()) {
			InputStream in = this.client.getInputStream();
			//Server-Zug wird gelesen
			int zug = (byte)in.read();
			//Zug wird gesetzt
			ret = this.setZugSpieler2(zug);
			//War dies erfolgreich, so wird der Client geschlossen
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
	 * Schlie�t den ClientSocket
	 * @throws java.io.IOException
	 */
	public void close() throws java.io.IOException {
		this.client.close();
	}
}
