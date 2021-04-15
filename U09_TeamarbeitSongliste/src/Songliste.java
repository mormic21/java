
public class Songliste {

	private int anzahl = 0;
	private static int DEFAULT_MAXANZAHL = 500;
	private int nummerAktueller = 0;
	private java.lang.String pfad = "";
	private Song[] songs;
	
	/**
	 * Konstruktor, der ein privates Array initialisiert 
	 * in welchem maxAnzahl Songs aufgenommen werden k�nnen. 
	 * Ist maxAnzahl <= 0, so wird �ber die interne songs-Variable ein Array angelegt das DEFAULT_MAXANZAHL Songs aufnehmen kann.
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
	 * Liefert die Maximale Anzahl von Songs zur�ck, die im Array abgespeichert werden k�nnen
	 * @return die Anzahl der im Array maximal eintragbaren Songs
	 */
	public int getMaxAnzahl() {
		return this.songs.length;
	}
	
	/**
	 * Gibt die Anzahl der Songs zur�ck, die momentan im Array vorhanden sind
	 * die Anzahl der Songs die im Array momentan eingetragen sind
	 * 0 falls das Array zwar angelegt wurde aber noch keine Elemente enthalten sind
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Liefert den aktuellen Song zur�ck auf den der Songzeiger nummerAktueller zeigt
	 * @return den aktuellen Song oder null, falls kein Song in der Songliste enthalten ist
	 */
	public Song getAktueller() {
		return songs[this.getNummerAktueller()];
	}
	
	/**
	 * Liefert den n�chsten Song - falls vorhanden - zur�ck und erh�ht den Songzeiger nummerAktueller um Eins. 
	 * Gibt es keinen n�chsten Song, wird null zur�ck geliefert und der Songzeiger nicht erh�ht
	 * @return liefert den n�chsten Song zur�ck oder null, falls dieser Song nicht vorhanden ist
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
	 * Liefert den vorigen Song - falls vorhanden - zur�ck und vermindert den Songzeiger um Eins. 
	 * Gibt es keinen vorigen Song wird null zur�ck geliefert und der Songzeiger nicht vermidert
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
	 * Liefert den ersten Song in der Songliste zur�ck und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zur�ck geliefert
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
	 * Liefert den letzten Song in der Songliste zur�ck und setzt den Songzeiger auf diesen Song. 
	 * Ist die Liste leer, wird null zur�ck geliefert
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
	 * Tr�gt einen neuen Song am Ende der Songliste ein. Die Anzahl der Songs wird um Eins erh�ht 
	 * und die nummerAktueller wird auf diesen Song gesetzt. 
	 * Der Song wird nicht eingetragen, wenn im Array kein Platz mehr ist.
	 * @param s, der einzutragende Song
	 * @return 0 falls das Eintragen erfolgreich war 
	 * 		  -1 falls kein einzutragender Song �bergeben wurde
	 * 		  -2 falls die Songliste keinen Platz f�r einen weiteren Song hat
	 */
	public int anfuegenNeuen(Song s) {
		int ret = -1;
		if (s != null) {
			if (this.getAnzahl() <= this.getMaxAnzahl()) {
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
	 * �ndert den aktuellen Song auf den �bergebenen Song ab und sortiert ihn nicht ein
	 * @param s, der Song der die zu �ndernden Werte enth�lt
	 * @return 0 falls die �nderung erfolgreich durchgef�hrt werden konnte 
	 * 		  -1 falls kein zu �ndernder Song �bergeben wurde
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
	
	//NOCH ZU MACHEN
	public int loeschenAktuellen() {
		return 0;
	}
	
	//NOCH ZU MACHEN
	public int loeschenAlle() {
		return 0;
	}
	
	//NOCH ZU MACHEN
	public int lesenSongs() {
		return 0;
	}
	
	//NOCH ZU MACHEN
	public int schreibenSongs() {
		return 0;
	}
	
	

}
