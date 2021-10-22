package net.tfobz.ratenrechner;

public class RatenRechner {
	boolean nachschuessig;
	double barwert;
	double jahreszinssatz;
	double laufzeitInJahren;
	int ratenProJahr;
	
	double rate;

	/**
	 * getBarwert
	 * @return den Barwert als String	
	 * @throws RatenRechnerException
	 */
	public String getBarwert() throws RatenRechnerException {
		if (this.jahreszinssatz <= 0 || this.laufzeitInJahren <= 0 || this.ratenProJahr <= 0 || this.rate <= 0) {
			throw new RatenRechnerException("Jahreszinssatz, Laufzeit, Raten pro Jahr oder Rate nicht gesetzt");
		}
		else {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			if (nachschuessig) {
				barwert = rate * (Math.pow(q, n) - 1.) / (Math.pow(q, n) * (q - 1.));
			}
			else {
				barwert = rate * (Math.pow(q, n)- 1.) / (Math.pow(q, n - 1.) * (q - 1.));
			}
			return String.valueOf(barwert);
		}
		
	}
	/**
	 * @param barwert the barwert to set
	 */
	public void setBarwert(String sbarwert) throws RatenRechnerException {
		double num;
		try {
			num = Double.parseDouble(sbarwert);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
		if (num <= 0) {
			throw new RatenRechnerException("Barwert kleiner oder gleich 0");
		}
		this.barwert = num;
	}
	/**
	 * @return the ratenProJahr
	 */
	public String getRatenProJahr() {
		return String.valueOf(ratenProJahr);
	}
	/**
	 * @param ratenProJahr the ratenProJahr to set
	 */
	public void setRatenProJahr(String ratenProJahr) throws RatenRechnerException{
		try {
			this.ratenProJahr = Integer.parseInt(ratenProJahr);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * @return the nachschuessig
	 */
	public boolean isNachschuessig() {
		return nachschuessig;
	}
	
	/**
	 * @param nachschuessig the nachschuessig to set
	 */
	public void setNachschuessig(boolean nachschuessig) {
		this.nachschuessig = nachschuessig;
	}
	
	/**
	 * getLaufzeitInJahren
	 * @return
	 * @throws RatenRechnerException
	 */
	public String getLaufzeitInJahren() throws RatenRechnerException {
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.rate <= 0 ) {
			throw new RatenRechnerException("Jahreszinssatz, Barwert, Raten pro Jahr oder Rate nicht gesetzt");
		}
		else {
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			if (nachschuessig) {
				laufzeitInJahren = (-Math.log((rate - barwert * (q - 1.)) / rate)/ Math.log(q)) / ratenProJahr;
			}
			else {
				laufzeitInJahren = (1. - Math.log((q * rate - barwert * (q - 1.)) / rate) / Math.log(q)) / ratenProJahr;
			}
			return String.valueOf(laufzeitInJahren);
		}	
	}
	
	/**
	 * @param laufzeitInJahren the laufzeitInJahren to set
	 */
	public void setLaufzeitInJahren(String laufzeitInJahren) throws RatenRechnerException {
		try {
			this.laufzeitInJahren = Double.parseDouble(laufzeitInJahren);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws RatenRechnerException
	 */
	public String getRate() throws RatenRechnerException {
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.laufzeitInJahren <= 0 ) {
			throw new RatenRechnerException("Jahreszinssatz, Laufzeit, Raten pro Jahr oder Barwert nicht gesetzt");
		}
		else {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			if (nachschuessig) {
				rate = barwert * (Math.pow(q, n) * (q - 1.)) / (Math.pow(q, n) - 1.);
			}
			else {
				rate = barwert * (Math.pow(q, n - 1.) * (q - 1.)) / (Math.pow(q, n) - 1.);
			}
			return String.valueOf(rate);
		}
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) throws RatenRechnerException {
		try {
			this.rate = Double.parseDouble(rate);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * @return the jahreszinssatz
	 */	
	public double getJahreszinssatz() {
		return jahreszinssatz;
	}
	/**
	 * @param jahreszinssatz the jahreszinssatz to set
	 */
	public void setJahreszinssatz(String jahreszinssatz) throws RatenRechnerException {
		try {
			this.jahreszinssatz = Double.parseDouble(jahreszinssatz);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("Kein gültiger Gleitkommawert");
		}
	}
	
	public String getTilgungsplan() throws RatenRechnerException {
		if (this.jahreszinssatz <= 0 || this.barwert <= 0 || this.ratenProJahr <= 0 || this.laufzeitInJahren <= 0 
				|| this.rate <= 0) {
			throw new RatenRechnerException("Führen Sie zuerst die Ratenberechnung");
		}
		else {
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
					"        <td>Nachschüssig</td>\r\n" + 
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
					"	 <table border=\"1\">\r\n" + 
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
				if (nachschuessig) {
					zinsen = restkapital * (q - 1.);
					restkapital = restkapital * q - rate;
				} else {
					zinsen = (restkapital - rate) * (q - 1.);
					restkapital = restkapital - rate + zinsen;
				}
				ret = ret + "<tr>\r\n" + 
						"        <td>"+i+"</td>\r\n" + 
						"        <td>"+Math.round(rate*100.0)/100.0+"</td>\r\n" + 
						"        <td>"+Math.round(restkapital*100.0)/100.0+"</td>\r\n" + 
						"        <td>"+Math.round(zinsen*100.0)/100.0+"</td>\r\n" + 
						"      </tr>\r\n";
			}
			ret = ret + "</table>\r\n</body>\r\n</html>";
			System.out.println(ret);
			return ret;
		}
		
	}
}
