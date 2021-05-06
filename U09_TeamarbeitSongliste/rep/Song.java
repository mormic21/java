	/**
 * Song-Klasse für die Verwendung von Objekten vom Typ Song mit seinen
 * Membervariablen und Methoden
 * 
 * @author Michael Morandell
 *
 */
public class Song {
	private String titel;
	private String interpret;
	private String album;
	private int erscheinungsjahr;

	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * @param titel
	 *            the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * @return the interpret
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * @param interpret
	 *            the interpret to set
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return the erscheinungsjahr
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}

	/**
	 * @param erscheinungsjahr
	 *            the erscheinungsjahr to set
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		if (erscheinungsjahr < 0)
			this.erscheinungsjahr = 0;
		else
			this.erscheinungsjahr = erscheinungsjahr;
	}

	/**
	 * Equals-Methode kontrolliert, ob der Song mit dem übergebenen Song
	 * übereinstimmt. Dabei werden Titel, Interpret, Album und Erscheinungsjahr
	 * einzeln verglichen.
	 * 
	 * @param obj,
	 *            Objekt, welches verglichen wird
	 * @return boolean, True wenn beide gleich
	 */
	public boolean equals(Object obj) {
		boolean ret = false;
		if (obj instanceof Song) {
			Song s = (Song) obj;
			if (this.getTitel().equals(s.getTitel())) {
				if (this.getInterpret().equals(s.getInterpret())) {
					if (this.getAlbum().equals(s.getAlbum())) {
						if (this.getErscheinungsjahr() == s.getErscheinungsjahr()) {
							ret = true;
						}
					}
				}
			}
		}
		return ret;
	}

	/**
	 * CompareTo-Methode. Die einzelnen Eigenschaften werden mit denselben
	 * Eigenschaften eines anderen Songs zeichenweise verglichen. Wenn der
	 * aufrufende Song größer ist, als der Parameter-Song, so wird 1
	 * zurückgeliefert. Ist der aufrufende Song kleiner, als der Parameter-Song, so
	 * wird -1 zurückgegeben. Sind die beiden Objekte gleich, so wird 0
	 * zurückgeliefert
	 * 
	 * @param s,
	 *            das zu vergleichende Song-Objekt
	 * @return integer: 1, 0 oder -1
	 */
	public int compareTo(Song s) {
		// Initialisierung
		int ret = 0;
		int value = 0;
		//Interpret wird kontrolliert
		if (this.getInterpret().compareTo(s.getInterpret()) == 0) {
			//Album wird verglichen
			if (this.getAlbum().compareTo(s.getAlbum()) == 0) {
				//Titel wird verglichen
				if (this.getTitel().compareTo(s.getTitel()) == 0) {
					//Wenn alles gleich, wird 0 zurückgegeben
					ret = 0;
				} else {
					value = this.getTitel().compareTo(s.getTitel());
				}
			} else {
				value = this.getAlbum().compareTo(s.getAlbum());
			}
		} else {
			value = this.getInterpret().compareTo(s.getInterpret());
		}
		//Filtern der Ergebnisse. -1 Wenn das Objtkt kleiner ist als das Parameter-Objekt ist, ansonsten 1;
		if (value < 0) {
			ret = -1;
		} else {
			ret = 1;
		}
		//Rückgabe
		return ret;
	}

	/**
	 * Erstellt eine Kopie vom Objekt Song
	 * 
	 * @return einen geclontes Objekt vom Typ Song
	 */
	public Song clone() {
		Song ret = new Song();
		ret.setTitel(this.getTitel());
		ret.setInterpret(this.getInterpret());
		ret.setAlbum(this.getAlbum());
		ret.setErscheinungsjahr(this.getErscheinungsjahr());
		return ret;
	}

	/**
	 * toString. Gibt den Inhalt eines Objektes vom Typ Song, zum ausgeben, zurück.
	 * Alle Informationen hintereinander, mit Strichpunkten getrennt, ohne spaces
	 * Beispiel: "A Hard Rain's A-Gonna Fall;The Best Of Volume 2;Bob Dylan;2000"
	 * 
	 * @return Inhalt des Song-Objektes als String
	 */
	public String toString() {
		String ret = this.getTitel() + ";" + this.getAlbum() + ";" + this.getInterpret() + ";"
				+ this.getErscheinungsjahr();
		return ret;
	}

	/**
	 * setSong. Zerlegt den ihr übergebenen String in Titel, Album, Interpret und
	 * Erscheinungsjahr und fügt die Teile in das Song-Objekt ein. Beispiel: "A Hard
	 * Rain's A-Gonna Fall;The Best Of Bob Dylan Volume 2;Bob Dylan;2000" Das
	 * Trennzeichen ist der Strichpunkt (;)
	 * 
	 * @param str,
	 *            String aus welchem die Song-Eigenschaften extrahiert werden
	 */
	public void setSong(String str) {
		String[] s = str.split(";");
		this.setTitel(s[0]);
		this.setAlbum(s[1]);
		this.setInterpret(s[2]);
		this.setErscheinungsjahr(Integer.decode(s[3]));
	}

}
