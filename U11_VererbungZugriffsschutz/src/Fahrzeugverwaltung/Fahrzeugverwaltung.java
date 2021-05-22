package Fahrzeugverwaltung;
import java.util.*;
/**
 * Fahrzeugverwaltung in der Konsole
 * @author Michael Morandell
 *
 */
public class Fahrzeugverwaltung {
	/**
	 * Main-Methode
	 * @param args
	 */
	public static void main(String[] args) {
		boolean loop = true;
		//Vector in welchem die Fahrzeuge gespeichert werden
		Vector <Fahrzeug> v = new Vector<Fahrzeug>();
		//schleife bis der Benutzer abbricht
		while (loop) {
			//Menü wird ausgegeben
			System.out.println("Fahrzeugverwaltung");
			System.out.println("==================");
			System.out.println("1 - Eingeben");
			System.out.println("2 - Suchen");
			System.out.println("3 - Ändern");
			System.out.println("4 - Löschen");
			System.out.println("5 - Liste");
			System.out.println("6 - Ende");
			//Benutzereingabe 1-6
			int input = TestScannerErweitert.readInt("Ihre Wahl (1 - 6): ");
			//Wenn ungültige Zahl eingegeben wird, muss der Benutzer nochmals eingeben
			while (input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6) {
				input = TestScannerErweitert.readInt("Ungültige Eingabe! Bitte Zahl von 1 - 6 eingeben: ");
			}
			//Wenn Benutzereingabe 1
			if (input == 1) {
				System.out.println("\n>> Eingeben: ");
				eingeben(v);
			}
			//Wenn Benutzereingabe 2
			if (input == 2) {
				System.out.println("\n>> Suchen: ");
				suchen(v);
			}
			//Wenn Benutzereingabe 3
			if (input == 3) {
				System.out.println("\n>> Ändern: ");
				aendern(v);
			}
			//Wenn Benutzereingabe 4
			if (input == 4) {
				System.out.println("\n>> Löschen: ");
				loeschen(v);
			}
			//Wenn Benutzereingabe 5
			if (input == 5) {
				System.out.println("\n>> Liste: ");
				liste(v);
			}
			//Wenn Benutzereingabe 6
			if (input == 6) {
				System.out.println("Fahrzeugverwaltung wird beendet...");
				loop = false;
			}
			System.out.println();
		}

	}
	
	/**
	 * Eingeben-Methode, in welcher der Benutzer ein neues Fahrzeug erstellen und in den Vector eintragen kann
	 * @param v, Vector vom Typ Fahrzeug
	 */
	public static void eingeben(Vector <Fahrzeug> v) {
		char fahrz = '0';
		//Auswahl ob Auto, Fahrrad oder Lastwagen, wird so lange wiederholt bis gültige Eingaben erfolgt sind
		while(fahrz != 'f' && fahrz != 'a' && fahrz != 'l') {
			fahrz = TestScannerErweitert.readChar("Wollen Sie ein [F]Fahrrad, ein [A]Auto oder einen [L]Lastwagen eingeben? ");
			Character.toLowerCase(fahrz);
		}
		switch (fahrz) {
			//Neues Fahrrad
			case 'f': {
				System.out.println("\n>> Eingeben\\Fahrrad: ");
				//Benutzereingabe der Informationen des Fahrrads
				int g = TestScannerErweitert.readInt("Geschwindigkeit des Fahrrads zwischen 0 und 60 km\\h: ");
				int k = TestScannerErweitert.readInt("Geben Sie den Kilometerstand des Fahrrads ein: ");
				char a = '0';
				while (a != 'j' && a != 'n') {
					a = TestScannerErweitert.readChar("Soll das Fahrrad eine Beleuchtung haben? [j]->ja, [n]->nein: ");
					Character.toLowerCase(a);
				}
				boolean b = false;
				if (a == 'j') {
					b = true;
				}
				else {
					b = false;
				}
				//Neues Fahrrad wird erstellt und die Eigenschaften gesetzt
				Fahrrad fd = new Fahrrad(g);
				fd.setKilometerstand(k);
				fd.setBeleuchtung(b);
				//Fahrrad wird im Vector gespeichert
				v.addElement(fd);
				//Ausgabe an Benutzer
				System.out.println("[info] Neues Fahrrad wurde erfolgreich hinzugefügt");
				break;
			}
			//Neues Auto
			case 'a': {
				System.out.println("\n>> Eingeben\\Auto: ");
				//Benutzereingabe der Eigenschaften des Autos
				int g = TestScannerErweitert.readInt("Geben Sie die Geschwindigkeit des Autos ein: ");
				int k = TestScannerErweitert.readInt("Geben Sie den Kilometerstand des Autos ein: ");
				int ps = TestScannerErweitert.readInt("Geben Sie die PS des Autos ein: ");
				//Auto-Objekt wird erstellt und Eigenschaften werden gesetzt
				Auto a = new Auto(g, ps);
				a.setKilometerstand(k);
				//Auto wird im Vector gespeichert
				v.addElement(a);
				//Augabe an den Benutzer
				System.out.println("[info] Neues Auto wurde erfolgreich hinzugefügt");
				break;
			}
			//Neuer Lastwagen
			case 'l': {
				System.out.println("\n>> Eingeben\\Lastwagen: ");
				//Benutzereingabe der Eigenschaften des Lastwagens
				int g = TestScannerErweitert.readInt("Geben Sie die Geschwindigkeit des Lastwagens ein: ");
				int k = TestScannerErweitert.readInt("Geben Sie den Kilometerstand des Lastwagens ein: ");
				int ps = TestScannerErweitert.readInt("Geben Sie die PS des Lastwagens ein: ");
				int lf = TestScannerErweitert.readInt("Geben sie die Ladefläche des Lastwagens ein: ");
				//Neues Lastwagen-Objekt wird erstellt und die Eigenschaften werden gesetzt
				Lastwagen lw = new Lastwagen(g, ps, lf);
				lw.setKilometerstand(k);
				//Lastwagen wird im Vector gespeichert
				v.addElement(lw);
				//Ausgabe an Benutzer
				System.out.println("[info] Neuer Lastwagen wurde erfolgreich hinzugefügt");
				break;
			}
		}
	}
	
	/**
	 * Suchen-Methode. Der Benutzer gibt die Nummer des zu suchenden Fahrzeugs ein. Wenn an dieser Stelle im Vector ein 
	 * Fahrzeug vorhanden ist, so wird dieses ausgegeben, ansonsten erfolgt eine Fehlermeldung
	 * @param v, Vector vom Typ Fahrzeug
	 */
	public static void suchen (Vector <Fahrzeug> v) {
		//Nummer des Fahrzeugs wird eingelesen
		int index = TestScannerErweitert.readInt("Bitte geben sie die Nummer des zu suchenden Fahrzeugs ein: ");
		//Wenn sich der eingegebene Index im Vector befindet, erfolgt die Ausgabe des Objekts
		if (index >= 0 && index < v.size()) {
			System.out.println(v.elementAt(index).toString());
		} 
		//Ansonsten erfolgt eine Fehlermeldung
		else {
			System.out.println("[error] Kein Fahrzeug mit dieser Nummer gefunden!");
		}
	}
	
	/**
	 * Der Benutzer gibt die Nummer des zu ändernden Objektes an. Dieses wird gesucht und angezeigt. 
	 * Der Benutzer kann die Datenelemente des Objektes ändern, und die Änderungen werden in den Vektor an derselben Stelle eingetragen.
	 * @param v, Vector vom Typ Fahrzeug
	 */
	public static void aendern (Vector <Fahrzeug> v) {
		//Nummer des Fahrzeugs wird eingelesen
		int index = TestScannerErweitert.readInt("Bitte geben sie die Nummer des zu ändernden Fahrzeugs ein: ");
		//Wenn sich der eingegebene Index im Vector befindet
		if (index >= 0 && index < v.size()) {
			//Fahrzeug an der Stekke wird geholt und dem Benutzer ausgegeben
			Fahrzeug fg = v.elementAt(index);
			System.out.println(fg.toString());
			//Wenn dieses Fahrzeug ein Fahrrad ist
			if (fg instanceof Fahrrad) {
				//Eigenschaften des Fahrrads werden geholt
				int geschwindigkeit = fg.getGeschwindigkeit();
				int kilometerstand = fg.getKilometerstand();
				boolean beleuchtung = ((Fahrrad) fg).isBeleuchtung();
				//Neues Fahrrad-Objekt wird erstellt und Eigenschaften gesetzt
				Fahrrad fd = new Fahrrad(geschwindigkeit);
				fd.setKilometerstand(kilometerstand);
				fd.setBeleuchtung(beleuchtung);
				//Benutzereingabe der Änderungen
				String newGeschw = TestScannerErweitert.readString("Neue Geschwindigkeit ([.] um alten Wert beizubehalten): ");
				String newKilo = TestScannerErweitert.readString("Neuer Kilometerstand ([.] um alten Wert beizubehalten): ");
				String newBel = TestScannerErweitert.readString("Beleuchtung [j]->ja [n]->nein ([.] um alten Wert beizubehalten): ");
				//Wenn Geschwindigkeit geändert werden soll
				if (!newGeschw.equals(".")) {
					try {
						//Int-Wert wird geparst und im neuen Objekt gesetzt
						fd.setGeschwindigkeit(Integer.parseInt(newGeschw));
					} catch (NumberFormatException e) {
						//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
						System.out.println("[error] Ungültige Eingabe. Alte Geschwindigkeit wird beibehalten");
					}
				}
				//Wenn Kilometer geändert werden soll
				if (!newKilo.equals(".")) {
					//Int-Wert wird geparst und im neuen Objekt gesetzt
					try {
						fd.setKilometerstand(Integer.parseInt(newKilo));
					} catch (NumberFormatException e) {
						//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
						System.out.println("[error] Ungültige Eingabe. Alter Kilometerstand wird beibehalten");
					}
				}
				//Wenn Beleuchtung geändert werden soll
				if (!newBel.equals(".")) {
					newBel.toLowerCase();
					//Wenn Eingabe j, wird Beleuchtung auf True gesetzt
					if (newBel.equals("j")) {
						fd.setBeleuchtung(true);
					}
					//Wenn Eingabe n, wird Beleuchtung auf false gesetzt
					if (newBel.equals("n")) {
						fd.setBeleuchtung(false);
					}
					//Wenn ungültige Eingabe, erfolgt Fehlermeldung
					if (!newBel.equals("j") && !newBel.equals("n")) {
						System.out.println("[error] Ungültige Eingabe. Alte Beleuchtung wird beibehalten");
					}
				}
				//Neues Fahrrad wird mit dem alten Fahrrad, an der Stelle index im Vector ersetzt
				v.set(index, fd);
				//Ausgabe der Änderungen an den Benutzer
				System.out.println("Fahrrad wurde erfolgreich abgeändert: "+fd.toString());
			}
			//Wenn Fahrzeug ein Auto ist
			if (fg instanceof Auto) {
				//Wenn Auto ein Lastwagen ist
				if (fg instanceof Lastwagen) {
					//Eigenschaften des Lastwagens werden geholt
					int geschwindigkeit = fg.getGeschwindigkeit();
					int kilometerstand = fg.getKilometerstand();
					int ps = ((Auto) fg).getPs();
					int ladeflaeche = ((Lastwagen) fg).getLadeflaeche();
					//Neues Lastwagen-Objekt wird erstellt und Eigenschaften gesetzt
					Lastwagen l = new Lastwagen(geschwindigkeit, ps, ladeflaeche);
					l.setKilometerstand(kilometerstand);
					//Benutzereingabe der Änderungen
					String newGeschw = TestScannerErweitert.readString("Neue Geschwindigkeit ([.] um alten Wert beizubehalten): ");
					String newKilo = TestScannerErweitert.readString("Neuer Kilometerstand ([.] um alten Wert beizubehalten): ");
					String newPs = TestScannerErweitert.readString("Neue PS ([.] um alten Wert beizubehalten): ");
					String newLadef = TestScannerErweitert.readString("Neue Ladefläche ([.] um alten Wert beizubehalten): ");
					//Wenn Geschwindigkeit geändert werden soll
					if (!newGeschw.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							l.setGeschwindigkeit(Integer.parseInt(newGeschw));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alte Geschwindigkeit wird beibehalten");
						}
					}
					//Wenn Kilometer geändert werden soll
					if (!newKilo.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							l.setKilometerstand(Integer.parseInt(newKilo));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alter Kilometerstand  wird beibehalten");
						}
					}
					//Wenn Ps geändert werden soll
					if (!newPs.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							l.setPs(Integer.parseInt(newPs));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alte PS werden beibehalten");
						}
					}
					//Wenn Ladefläche geändert werden soll
					if (!newLadef.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							l.setLadeflaeche(Integer.parseInt(newLadef));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alte Ladefläche wird beibehalten");
						}
					}
					//Neuer Lastwagen wird mit dem alten Lastwagen an der Stelle index im Vector erstzt
					v.set(index, l);
					//Ausgabe der Änderungen an den Benutzer
					System.out.println("Lastwagen wurde erfolgreich abgeändert: "+l);
				}
				//Wenn Auto ein Auto ist
				else {
					//Eigenschaften des Autos werden geholt
					int geschwindigkeit = fg.getGeschwindigkeit();
					int kilometerstand = fg.getKilometerstand();
					int ps = ((Auto) fg).getPs();
					//Neues Auto-Objekt wird erstellt und Eigenschaften gesetzt
					Auto a = new Auto(geschwindigkeit, ps);
					a.setKilometerstand(kilometerstand);
					//Benutzereingabe der Änderungen
					String newGeschw = TestScannerErweitert.readString("Neue Geschwindigkeit ([.] um alten Wert beizubehalten): ");
					String newKilo = TestScannerErweitert.readString("Neuer Kilometerstand ([.] um alten Wert beizubehalten): ");
					String newPs = TestScannerErweitert.readString("Neue PS ([.] um alten Wert beizubehalten): ");
					//Wenn Geschwindigkeit geändert werden soll
					if (!newGeschw.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							a.setGeschwindigkeit(Integer.parseInt(newGeschw));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alte Geschwindigkeit wird beibehalten");
						}
					}
					//Wenn Kilometer geändert werden soll
					if (!newKilo.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							a.setKilometerstand(Integer.parseInt(newKilo));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alter Kilometerstand wird beibehalten");
						}
					}
					//Wenn Ps geändert werden soll
					if (!newPs.equals(".")) {
						try {
							//Int-Wert wird geparst und im neuen Objekt gesetzt
							a.setPs(Integer.parseInt(newPs));
						} catch (NumberFormatException e) {
							//Fehlermeldung, wenn ein anderes Zeichen eingegben wurde
							System.out.println("[error] Ungültige Eingabe. Alte PS werden beibehalten");
						}
					}
					//Neues Auto wird mit dem alten Auto an der Stelle index im Vector erstzt
					v.set(index, a);
					System.out.println("Auto wurde erfolgreich abgeändert: "+a);
				}
			}
		}
		//Fehlermeldung, wenn es kein Fahrzeug mit der eingegebenen Nummer gibt
		else {
			System.out.println("[error] Kein Fahrzeug mit dieser Nummer gefunden!");
		}
	}
	
	/**
	 * loeschen-Methode	
	 * Der Benutzer gibt die Nummer des zu löschenden Objektes ein. 
	 * Falls ein Objekt an dieser Stelle im Vektor vorhanden ist, wird es gelöscht.
	 * @param v, Vector vom Typ Fahrzeug
	 */
	public static void loeschen(Vector <Fahrzeug> v) {
		//Eingabe der Fahrzeugnummer
		int index = TestScannerErweitert.readInt("Bitte geben sie die Nummer des zu ändernden Fahrzeugs ein: ");
		//Wenn index im Vector vorhanden ist
		if (index >= 0 && index < v.size()) {
			//Ausgabe des Objektes an den Benutzer
			System.out.println(v.elementAt(index).toString());
			//Löschabfrage
			char c = TestScannerErweitert.readChar("Wollen sie dieses Fahrzeug wirklich löschen? [j]->ja, [n]->nein: ");
			Character.toLowerCase(c);
			//Wenn Bestätigung
			if (c == 'j') {
				//Element am Index wird gelöscht
				v.removeElementAt(index);
				//Ausgabe an Benutzer
				System.out.println("Fahrzeug wurde gelöscht");
			}
		}
		//Fehlermeldung wenn Fahrzeugsnummer nicht vorhanden ist
		else {
			System.out.println("[error] Kein Fahrzeug mit dieser Nummer gefunden!");
		}
	}
	
	/**
	 * Liste-Methode
	 * Es wird eine Liste aller im Vektor enthaltenen Objekte ausgegeben. 
	 * Dabei wird jedes Objekt in einer einzelnen Zeile platziert. 
	 * Am Beginn der Zeile wird die Nummer des Objektes, der Typ und die Datenelemente ausgegeben
	 * @param v, Vector als Typ von Fahrzeug
	 */
	public static void liste(Vector <Fahrzeug> v) {
		//Vector wird durchiteriert und die Elemente werden einzeln ausgegeben
		for (int i = 0; i < v.size(); i++) {
			System.out.println(i+": "+v.elementAt(i).toString());
		}
	}

}
