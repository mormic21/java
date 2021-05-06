import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Songliste {

	private int anzahl = 0;
	private static int DEFAULT_MAXANZAHL = 500;
	private int nummerAktueller = 0;
	private java.lang.String pfad = "";
	private Song[] songs;
	
	/**
	 * Konstruktor, der ein privates Array initialisiert 
	 * in welchem maxAnzahl Songs aufgenommen werden können. 
	 * Ist maxAnzahl <= 0, so wird über die interne songs-Variable ein Array angelegt das DEFAULT_MAXANZAHL Songs aufnehmen kann.
	 *  Weiters wird anzahl auf 0 gesetzt weil noch keine Songs in der Liste vorhanden sind und nummerAktueller auf -1, 
	 *  weil noch kein Song angesprungen wurde
	 * @param maxAnzahl
	 */
	Songliste(int maxAnzahl) {
		if (maxAnzahl <=  0) {
			songs = new Song[DEFAULT_MAXANZAHL];
		}
		else {
			songs = new Song[maxAnzahl];
		}
		this.setAnzahl(0);
		this.setNummerAktueller(-1);
	}
	
	/**
	 * @param anzahl the anzahl to set
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	/**
	 * @return the dEFAULT_MAXANZAHL
	 */
	public static int getDEFAULT_MAXANZAHL() {
		return DEFAULT_MAXANZAHL;
	}

	/**
	 * @param dEFAULT_MAXANZAHL the dEFAULT_MAXANZAHL to set
	 */
	public static void setDEFAULT_MAXANZAHL(int dEFAULT_MAXANZAHL) {
		DEFAULT_MAXANZAHL = dEFAULT_MAXANZAHL;
	}

	/**
	 * @return the nummerAktueller
	 */
	public int getNummerAktueller() {
		return this.nummerAktueller;
	}

	/**
	 * @param nummerAktueller the nummerAktueller to set
	 */
	public void setNummerAktueller(int nummerAktueller) {
		this.nummerAktueller = nummerAktueller;
	}

	/**
	 * Liefert die Maximale Anzahl von Songs zurück, die im Array abgespeichert werden können
	 * @return die Anzahl der im Array maximal eintragbaren Songs
	 */
	public int getMaxAnzahl() {
		return this.songs.length;
	}
	
	/**
	 * Gibt die Anzahl der Songs zurück, die momentan im Array vorhanden sind
	 * die Anzahl der Songs die im Array momentan eingetragen sind
	 * 0 falls das Array zwar angelegt wurde aber noch keine Elemente enthalten sind
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Liefert den aktuellen Song zurück auf den der Songzeiger nummerAktueller zeigt
	 * @return den aktuellen Song oder null, falls kein Song in der Songliste enthalten ist
	 */
	public Song getAktueller() {
		return songs[this.getNummerAktueller()];
	}
	
	/**
	 * Liefert den nächsten Song - falls vorhanden - zurück und erhöht den Songzeiger nummerAktueller um Eins. 
	 * Gibt es keinen nächsten Song, wird null zurück geliefert und der Songzeiger nicht erhöht
	 * @return liefert den nächsten Song zurück oder null, falls dieser Song nicht vorhanden ist
	 */
	public Song getNaechster() {
		Song ret = null;
		if (this.songs[this.getNummerAktueller()+1] != null) {
			this.setNummerAktueller(getNummerAktueller()+1);
			ret = this.songs[this.getNummerAktueller()];
		}
		return ret;
	}
	
	/**
	 * Liefert den vorigen Song - falls vorhanden - zurück und vermindert den Songzeiger um Eins. 
	 * Gibt es keinen vorigen Song wird null zurück geliefert und der Songzeiger nicht vermidert
	 * @return den vorigen Song
	 */
	public Song getVoriger() {
		Song ret = null;
		if (this.songs[this.getNummerAktueller()-1] != null) {
			this.setNummerAktueller(getNummerAktueller()-1);
			ret = this.songs[this.getNummerAktueller()];
		}
		return ret;
	}
	
	/**
	 * Liefert den ersten Song in der Songliste zurück und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zurück geliefert
	 * @return den ersten Song in der Liste
	 */
	public Song getErster() {
		Song ret = null;
		if (this.getAnzahl() > 0) {
			this.setNummerAktueller(0);
			ret = this.songs[this.getNummerAktueller()];
		}
		return ret;
	}
	
	/**
	 * Liefert den letzten Song in der Songliste zurück und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zurück geliefert
	 * @return den letzten Song
	 */
	public Song getLetzter() {
		Song ret = null;
		if (this.getAnzahl() > 0) {
			this.setNummerAktueller(this.getAnzahl()-1);
			ret = this.songs[this.getNummerAktueller()];
		}
		return ret;
	}

	/**
	 * Setzt den Dateipfad auf jene Datei aus welcher die Songs gelesen bzw. in welche die Songs geschrieben werden soll
	 * @param pfad als String
	 */
	public void setPfad(java.lang.String pfad) {
		this.pfad = pfad;
	}

	/**
	 * Liest den Dateipfad aus
	 * @return dateipfad
	 */
	public java.lang.String getPfad() {
		return this.pfad;
	}
	
	/**
	 * Trägt einen neuen Song am Ende der Songliste ein. Die Anzahl der Songs wird um Eins erhöht 
	 * und die nummerAktueller wird auf diesen Song gesetzt. 
	 * Der Song wird nicht eingetragen, wenn im Array kein Platz mehr ist.
	 * @param s, der einzutragende Song
	 * @return 0 falls das Eintragen erfolgreich war 
	 * 		  -1 falls kein einzutragender Song übergeben wurde
	 * 		  -2 falls die Songliste keinen Platz für einen weiteren Song hat
	 */
	public int anfuegenNeuen(Song s) {
		int ret = -1;
		if (s != null) {
			if (this.getAnzahl() < this.getMaxAnzahl()) {
				this.setNummerAktueller(this.getAnzahl());
				this.setAnzahl(this.getAnzahl()+1);
				this.songs[this.getNummerAktueller()] = s;
				ret = 0;
			}
			else {
				ret = -2;
			}
		}
		return ret;
	}
	
	/**
	 * Ändert den aktuellen Song auf den übergebenen Song ab und sortiert ihn nicht ein
	 * @param s, der Song der die zu ändernden Werte enthält
	 * @return 0 falls die Änderung erfolgreich durchgeführt werden konnte 
	 * 		  -1 falls kein zu ändernder Song übergeben wurde
	 * 		  -2 falls der aktuelle Song nicht bekannt ist
	 */
	public int aendernAktuellen(Song s) {
		int ret = -1;
		if (s != null) {
			if (this.getNummerAktueller() > 0) {
				songs[this.getNummerAktueller()] = s;
				ret = 0;
			}
			else {
				ret = -2;
			}
		}
		return ret;
	}
	
	/**
	 * Löscht den aktuellen Song aus der Liste. 
	 * Dies kann nur passieren, wenn die Nummer des aktuellen Songs gesetzt ist. 
	 * Da im Array eine Lücke entsteht, müssen alle nachfolgenden Songs um eine Stelle nach vorne geschoben werden. 
	 * Der aktuelle Song wird jener Song der dem zu löschenden Song folgt. 
	 * Ist der zu löschende Song der letzte Song in der Liste, so wird der aktuelle Song jener Song der vor dem zu löschenden 
	 * Song vorhanden ist. Ist der zu löschende Song der einzige in der Liste, so wird die nummerAktueller auf -1 gesetzt. 
	 * Beim Löschen wird anzahl um Eins verringert
	 * @return 0 falls das Löschen erfolgreich durchgeführt werden konnte
	 * 		  -1 falls der aktuelle Song noch nicht gesetzt wurde
	 */
	public int loeschenAktuellen() {
		int ret = -1;
		if (this.getNummerAktueller() >= 0) {
			if (this.getNummerAktueller() == this.getAnzahl()-1) {
				songs[this.getNummerAktueller()] = null;
				this.setNummerAktueller(this.getNummerAktueller()-1);
				this.setAnzahl(this.getAnzahl()-1);
				ret = 0;
			}
			else {
				if (this.getNummerAktueller() == 0 && this.getAnzahl() == 1) {
					songs[this.getNummerAktueller()] = null;
					this.setNummerAktueller(-1);
					this.setAnzahl(this.getAnzahl()-1);
					ret = 0;
				}
				else {
					for (int i = this.getNummerAktueller(); i < this.getAnzahl(); i++) {
						songs[i] = songs[i+1];
					}
					this.setNummerAktueller(this.getNummerAktueller()+1);
					this.setAnzahl(this.getAnzahl()-1);
					ret = 0;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Löscht alle Songs aus der Liste. Setzt die Anzahl auf 0 und die Nummer des aktuellen Songs auf -1
	 * @return 0 falls das Löschen erfolgreich war
	 * 		  -1 falls die Liste bereits leer ist
	 */
	public int loeschenAlle() {
		int ret = -1;
		if (this.getAnzahl() > 0 && this.getNummerAktueller() > -1) {
			for (int i = 0; i < this.getAnzahl(); i++) {
				songs[i] = null;
			}
			ret = 0;
		}
		return ret;
	}
	
	/**
	 * Lädt die Songs aus der Textdatei die in pfad vorhanden ist. 
	 * Dabei werden die bereits in der Songliste gespeicherten Songs gelöscht. 
	 * Nach dem Einfügen sind die Songs in sortierter Reihenfolge vorhanden. 
	 * Als aktueller Song wird der Erste angesprungen
	 * @return 0 falls die Songs erfolgreich ein gefügt werden konnten
	 * 		  -1 falls der Pfad nicht gesetzt ist
	 * 		  -2 falls die Datei nicht zu finden ist
	 * 		  -3 falls ein Lesefehler in der Datei vorhanden ist
	 * 		  -4 das interner Array kann nicht alle Songs aufnehmen, weil es zu klein dimensioniert ist
	 */
	public int lesenSongs() {
		int ret = 0;
		//Allle löschen
		for (int i = 0; i < songs.length; i++) {
			songs[i] = null;
		}
		if (this.getPfad() != null) {
			int counter = 0;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(this.getPfad()));
				while (true) {
					String zeile = reader.readLine();
					// Dateiende erkannt
					if (zeile == null)
						break;
					// Zeile wird gezählt
					else
						counter++;
				}
				reader.close();
			} catch (FileNotFoundException e) {
				ret = -2;
			} catch (IOException e) {
				ret = -3;
			}
			if (counter > this.getMaxAnzahl()) {
				ret = -4;
			}
			//Falls es noch nicht zum Fehler gekommen ist
			if (ret == 0) {
				String line;
				try {
					BufferedReader reader = new BufferedReader(new FileReader(this.getPfad()));
					// Das Song-Array wird Element für Element durchgegangen
					for (int i = 0; i <= counter; i++) {
						// Zeile wird gelesen und in der String-Variable zeile gespeichert
						line = reader.readLine();
						// Instanziierung des Song-Objektes an der Stelle i im Array
						songs[i] = new Song();
						/*
						 * Das Song-Objekt erhält den Inhalt der zuvor ausgelesenen Zeile. Dazu wird die
						 * Methode setSong aus der Klasse Song verwendet
						 */
						songs[i].setSong(line);
						// Hilfsvariable
						int j = i;
						/*
						 * Solange j größer, als der kleinste Index 0 ist und das Objekt an der Stelle j
						 * kleiner ist, als das Objekt an der Stelle j-1...
						 */
						while (j > 0 && songs[j].compareTo(songs[j - 1]) == -1) {
							// Ein Hilfs-Objekt vom Typ Song
							Song help = new Song();
							// Die beiden Objekte werden im Array vertauscht
							help = songs[j - 1];
							songs[j - 1] = songs[j];
							songs[j] = help;
							// Fortschaltung
							j--;
						}
					}
					ret = 0;
					reader.close();
				} catch (FileNotFoundException e) {
					ret = -2;
				} catch (IOException e) {
					ret = -3;
				}
			}
		}
		else {
			ret = -1;
		}
		return ret;
	}
	
	/**
	 * Schreibt die Songs in die Textdatei. Dabei werden die in der Datei gespeicherten Songs gelöscht
	 * @return 0 falls die Songs erfolgreich ein gefügt werden konnten
	 * 		  -1 falls der Pfad nicht gesetzt wurde
	 *        -2 falls die Datei nicht angelegt werden konnte
	 */
	public int schreibenSongs() {
		int ret = -1;
		if (this.getPfad() != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(this.getPfad()));
				//Schreiben der Songs
				for (int i = 0; i < anzahl; i++) {
					writer.write(songs[i].toString());
					if (i < anzahl-1) {
						writer.write("\n");
					}
				}
				ret = 0;
				writer.close();
			} catch (IOException e) {
				ret = -2;
			}
		}
		return ret;
	}
	
	

}
