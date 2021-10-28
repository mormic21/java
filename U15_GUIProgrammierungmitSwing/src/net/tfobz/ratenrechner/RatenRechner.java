package net.tfobz.ratenrechner;

/**
 * RatenRechner.java
 * stellt die Verarbeitungslogik für RatenRechnerGUI zur Verfügung
 * @author Michael Morandell
 *
 */
public class RatenRechner {
	//Boolean -> true, wenn Nachschuessig
	private boolean nachschuessig;
	//Barwert, als double
	private double barwert;
	//Jahreszinssatz, als double
	private double jahreszinssatz;
	//Die Laufzeit in Jahren, als Double
	private double laufzeitInJahren;
	//Die Raten pro Jahr, als Integer
	private int ratenProJahr;
	//Die Rate, als double
	private double rate;

	/**
	 * isNachschuessig
	 * @return the nachschuessig
	 */
	public boolean isNachschuessig() {
		return nachschuessig;
	}

	/**
	 * setNachschuessig
	 * @param nachschuessig the nachschuessig to set
	 */
	public void setNachschuessig(boolean nachschuessig) {
		this.nachschuessig = nachschuessig;
	}

	/**
	 * getBarwert
	 * Berechnet aus den vorliegenden Eigenschaften den Barwert und gibt diesen zurück
	 * Ist eine benötigte Eigenschaft nicht gesetzt, so wird eine RatenRechnerException geworfen
	 * @return den Barwert als String	
	 * @throws RatenRechnerException
	 */
	public String getBarwert() throws RatenRechnerException {
		//Wenn eine Eigenschaft nicht vorhanden ist
		if (this.jahreszinssatz <= 0 || this.laufzeitInJahren <= 0 || this.ratenProJahr <= 0 || this.rate <= 0) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Jahreszinssatz, Laufzeit, Raten pro Jahr oder Rate nicht gesetzt");
		}
		//Ansonsten, wenn alle Eigenschaften gegeben sind
		else {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			//Wenn Nachschuessig
			if (nachschuessig) {
				barwert = rate * (Math.pow(q, n) - 1.) / (Math.pow(q, n) * (q - 1.));
			}
			else {
				barwert = rate * (Math.pow(q, n)- 1.) / (Math.pow(q, n - 1.) * (q - 1.));
			}
			//runden auf 2 Nachkommastellen
			barwert = Math.round(barwert*100.0)/100.0;
			//return string von barwert
			return String.valueOf(barwert);
		}
	}
	
	/**
	 * setBarwert
	 * setzt die Membervariable barwert mit der Doublezahl vom übergebenen String sbarwert.
	 * Eine RatenRechnerException wird geworfen, wenn der String ungueltige Zeichen enthaelt oder
	 * die Zahl kleiner gleich 0 ist
	 * @param barwert the barwert to set
	 * @throws RatenRechnerException
	 */
	public void setBarwert(String sbarwert) throws RatenRechnerException {
		double num;
		try {
			//Umwandlung des Strings in Double
			num = Double.parseDouble(sbarwert);
		//Falls ungueltige Zeichen enthalten sind
		} catch (NumberFormatException e) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
		//Falls Zahl kleiner gleich 0 ist
		if (num <= 0) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Barwert kleiner oder gleich 0");
		}
		//setzen der Membervariable
		this.barwert = num;
	}
	
	/**
	 * getJahreszinssatz
	 * @return the jahreszinssatz
	 */	
	public double getJahreszinssatz() {
		return jahreszinssatz;
	}

	/**
	 * setJahreszinssatz
	 * setzt die Membervariable jahreszinssatz auf den Double-Wert des uebergebenen Strings jahreszinssatz
	 * Wenn der String kein gueltiger Doublewert ist, wird eine Ratenrechner-Exception geworfen
	 * @param jahreszinssatz the jahreszinssatz to set
	 * @throws RatenRechnerException
	 */
	public void setJahreszinssatz(String jahreszinssatz) throws RatenRechnerException {
		try {
			//Umwandlung des Strings in eine Doublezahl
			this.jahreszinssatz = Double.parseDouble(jahreszinssatz);
			//Wenn ungueltiger Wert
		} catch (NumberFormatException e) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}

	/**
	 * getLaufzeitInJahren
	 * Berechnet aus den vorliegenden Eigenschaften die Laufzeit in Jahren und gibt diese zurück
	 * Ist eine benötigte Eigenschaft nicht gesetzt, so wird eine RatenRechnerException geworfen
	 * @return laufzeitInJahren, als String
	 * @throws RatenRechnerException
	 */
	public String getLaufzeitInJahren() throws RatenRechnerException {
		//Falls eine Eigenschaft fehlt
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.rate <= 0 ) {
			//RatenrechnerException wird geworfen
			throw new RatenRechnerException("Jahreszinssatz, Barwert, Raten pro Jahr oder Rate nicht gesetzt");
		}
		//Falls alle Eigenschaften vorhanden sind
		else {
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			//Wenn nachschuessig
			if (nachschuessig) {
				laufzeitInJahren = (-Math.log((rate - barwert * (q - 1.)) / rate)/ Math.log(q)) / ratenProJahr;
			}
			else {
				laufzeitInJahren = (1. - Math.log((q * rate - barwert * (q - 1.)) / rate) / Math.log(q)) / ratenProJahr;
			}
			//runden der Doublezahl auf 2 Nachkommastellen
			laufzeitInJahren = Math.round(laufzeitInJahren*100.0)/100.0;
			//String von laufzeitInJahren wird zurückgegeben
			return String.valueOf(laufzeitInJahren);
		}	
	}

	/**
	 * setLaufzeitInJahren
	 * setzt die Membervariable laufzeitInJahren auf den Double-Wert des uebergebenen Strings laufzeitInJahren
	 * Wenn der String kein gueltiger Doublewert ist, wird eine Ratenrechner-Exception geworfen
	 * @param laufzeitInJahren the laufzeitInJahren to set
	 */
	public void setLaufzeitInJahren(String laufzeitInJahren) throws RatenRechnerException {
		try {
			//Umwandlung des Strings in eine Doublezahl
			this.laufzeitInJahren = Double.parseDouble(laufzeitInJahren);
			//Wenn ungueltiger Wert
		} catch (NumberFormatException e) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}

	/**
	 * getRatenProJahr
	 * @return the ratenProJahr, als String
	 */
	public String getRatenProJahr() {
		return String.valueOf(ratenProJahr);
	}
	
	/**
	 * setRatenProJahr
	 * setzt die Membervariable ratenProJahr auf den Double-Wert des uebergebenen Strings ratenProJahr
	 * Wenn der String kein gueltiger Doublewert ist, wird eine Ratenrechner-Exception geworfen
	 * @param ratenProJahr the ratenProJahr to set
	 */
	public void setRatenProJahr(String ratenProJahr) throws RatenRechnerException{
		try {
			//Umwandlung des Strings in eine Doublezahl
			this.ratenProJahr = Integer.parseInt(ratenProJahr);
			//Wenn ungueltiger Wert
		} catch (NumberFormatException e) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * getRate
	 * Berechnet aus den vorliegenden Eigenschaften die Rate und gibt diese zurück
	 * Ist eine benötigte Eigenschaft nicht gesetzt, so wird eine RatenRechnerException geworfen
	 * @return rate, als String
	 * @throws RatenRechnerException
	 */
	public String getRate() throws RatenRechnerException {
		//Falls eine Eigenschaft fehlt
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.laufzeitInJahren <= 0 ) {
			//RatenrechnerException wird geworfen
			throw new RatenRechnerException("Jahreszinssatz, Laufzeit, Raten pro Jahr oder Barwert nicht gesetzt");
		}
		//Falls alle Eigenschaften vorhanden sind
		else {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			//Wenn nachschuessig
			if (nachschuessig) {
				rate = barwert * (Math.pow(q, n) * (q - 1.)) / (Math.pow(q, n) - 1.);
			}
			else {
				rate = barwert * (Math.pow(q, n - 1.) * (q - 1.)) / (Math.pow(q, n) - 1.);
			}
			//runden der Doublezahl auf 2 Nachkommastellen
			rate = Math.round(rate*100.0)/100.0;
			//String von rate wird zurückgegeben
			return String.valueOf(rate);
		}
	}

	/**
	 * setRate
	 * setzt die Membervariable rate auf den Double-Wert des uebergebenen Strings rate
	 * Wenn der String kein gueltiger Doublewert ist, wird eine Ratenrechner-Exception geworfen
	 * @param rate the rate to set
	 */
	public void setRate(String rate) throws RatenRechnerException {
		try {
			//Umwandlung des Strings in eine Doublezahl
			this.rate = Double.parseDouble(rate);
			//Wenn ungueltiger Wert
		} catch (NumberFormatException e) {
			//RatenRechnerException wird geworfen
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * getTilgungsplan
	 * holt sich alle Eigenschaften und erstellt daraus einen Tilgunsplan im HTML-Format.
	 * Ist eine Eigenschaft nicht gesetzt, so wird eine RatenRechnerException geworfen
	 * @return Tilgungsplan im HTML-Format, als String
	 * @throws RatenRechnerException
	 */
	public String getTilgungsplan() throws RatenRechnerException {
		//Wenn eine Eigenschaft fehlt
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.laufzeitInJahren <= 0 
				|| this.rate <= 0) {
			//RatenrechnerException wird geworfen
			throw new RatenRechnerException("Führen Sie zuerst die Ratenberechnung durch");
		}
		//Wenn alle Eigenschaften vorhanden sind
		else {
			//Setzen des Zahlungsart-Strings
			String art = "";
			if (this.isNachschuessig()) {
				art = "Nachschüssig";
			}
			else {
				art = "Vorschüssig";
			}
			//Erster Teil des Tilgunsplans mit den grundlegenden Informationen
			String ret = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"de\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <title></title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <h1>T I L G U N G S P L A N</h1>\r\n" + 
					"    <table border=\"1\">\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Zahlungsart:</td>\r\n" + 
					"        <td>"+art+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Barwert:</td>\r\n" + 
					"        <td>"+Math.round(barwert*100.0)/100.0+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Jahreszinssatz:</td>\r\n" + 
					"        <td>"+Math.round(jahreszinssatz*100.0)/100.0+"%</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Laufzeit in Jahren:</td>\r\n" + 
					"        <td>"+Math.round(laufzeitInJahren*100.0)/100.0+"</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Rückzahlungsart:</td>\r\n" + 
					"        <td>"+ratenProJahr+" Raten im Jahr</td>\r\n" + 
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"        <td>Rate:</td>\r\n" + 
					"        <td><b>"+Math.round(rate*100.0)/100.0+"</b></td>\r\n" + 
					"      </tr>\r\n" + 
					"    </table>\r\n" + 
					"    <hr>\r\n" + 
					"	 <table border=\"1\" width='100%'>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Periode</th>\r\n" + 
					"        <th>Rate</th>\r\n" + 
					"        <th>Restkapital</th>\r\n" + 
					"        <th>Zinsen</th>\r\n" + 
					"      </tr>\r\n";
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			double restkapital = barwert;
			for (int i = 1; i <= (int)(laufzeitInJahren*ratenProJahr); ++i) {
				final double zinsen;
				//Wenn nachschuessig
				if (nachschuessig) {
					zinsen = restkapital * (q - 1.);
					restkapital = restkapital * q - rate;
				} else {
					zinsen = (restkapital - rate) * (q - 1.);
					restkapital = restkapital - rate + zinsen;
				}
				//Erstellung der Tabelle mit den Raten
				ret = ret + "<tr>\r\n" + 
						"        <td>"+i+"</td>\r\n" + 
						"        <td>"+Math.round(rate*100.0)/100.0+"</td>\r\n" + 
						"        <td>"+Math.round(restkapital*100.0)/100.0+"</td>\r\n" + 
						"        <td>"+Math.round(zinsen*100.0)/100.0+"</td>\r\n" + 
						"      </tr>\r\n";
			}
			//ende der HTML-Datei
			ret = ret + "</table>\r\n</body>\r\n</html>";
			//return
			return ret;
		}
		
	}
}
