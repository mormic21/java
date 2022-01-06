package net.tfobz.kontoverwaltung;

import java.util.Calendar;

/**
 * Die Klasse GehaltsKonto hat zum Unterschied zu einem normalen Konto einen
 * �berziehungsrahmen, welcher beim Buchen nicht unterschritten werden darf. Ein
 * Start�berziehungsrahmen kann f�r alle anzulegenden Gehaltskonten vorab
 * eingestellt werden. Jedes Gehaltkonto hat einen �berziehungsrahmen der beim
 * Buchen nicht unterschritten werden darf �berziehungsrahmen werden immer als
 * negative Zahlen angegeben Ein Start�berziehungsrahmen kann f�r alle
 * anzulegenden Gehaltskonten vorab eingestellt werden Gebucht wird auf dem
 * Konto immer unter Ber�cksichtigung des �berziehungsrahmens. Der Kontostand
 * darf diesen nicht unterschreiten Die Zinsen des Gehaltskonto werden auf dem
 * aktuellen Kontostand gerechnet. Ist dieser negativ, sind die Zinsen 0
 * ansonsten werden vom heutigen Tag bis zum Jahresende die Zinsen berechnet Die
 * Spesen des Gehaltskontos sind 0, wenn der Kontostand nicht negativ ist,
 * ansonsten belaufen sie sich auf 50
 * 
 * extends Konto
 * @author Michael Morandell
 *
 */
public class Gehaltskonto extends Konto {
	//Legt den Start�berziehungsrahmen f�r alle neu anzulegenden Gehaltskonten fest
	protected static double startueberziehung;
	//Der �berziehungsrahmen des Gehaltskontos
	protected double ueberziehung;
	
	/**
	 * Konstruktor, welcher beim Anlegen des Gehaltskontos den �berziehungsrahmen automatisch vergibt. 
	 * Beim Anlegen des Gehaltskontos wird automatisch der �berziehungsrahmen, 
	 * welcher durch setStartueberziehung gesetzt wurde, f�r das Gehaltskonto eingestellt
	 */
	public Gehaltskonto() {
		super();
		try {
			this.setUeberziehung(Gehaltskonto.startueberziehung);
		} catch (KontoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Setzt den Start�berziehungsrahmen f�r alle neu anzulegenden Gehaltskonten
	 * @param startueberziehung - der zu setzen ist
	 * @throws KontoException - falls der �berziehungsrahmen gr��er als Null ist
	 */
	public static void setStartueberziehung(double startueberziehung)
	        throws KontoException {
		//Wenn Start�berziehung groesser als 0 ist
		if (startueberziehung > 0) {
			throw new KontoException("Start�berziehungsrahmen ist gr��er als 0 \n Bitte setzten sie einen negativen Wert");
		}
		//Wenn Start�berziehung einen gueltigen Wert hat
		else {
			Gehaltskonto.startueberziehung = startueberziehung;
		}
	}
	
	/**
	 * Gibt den �berziehungsrahmen zur�ck, der f�r alle neu zu erstellenden Konten verwendet wird
	 * @return den Start�berziehungsrahmen f�r alle neu anzulegenden Konten
	 */
	public static double getStartueberziehung() {
		return Gehaltskonto.startueberziehung;
	}
	
	/**
	 * Setzt f�r das Konto den �berziehungsrahmen. Der �berziehungsrahmen darf nicht positiv sein
	 * @param ueberziehung - darf nicht gr��er als Null sein
	 * @throws KontoException - falls der einzustellende �berziehungsrahmen gr��er als Null ist
	 */
	public void setUeberziehung(double ueberziehung)
	        throws KontoException {
		//Wenn �berziehung groesser als 0 ist
		if (ueberziehung > 0) {
			throw new KontoException("�berziehungsrahmen ist gr��er als Null");
		}
		//Wenn �berziehung einen gueltigen Wert hat
		else {
			this.ueberziehung = ueberziehung;
		}
	}
	
	/**
	 * Liefert den �berziehungsrahmen des Kontos zur�ck
	 * @return den �berziehungsrahmen des Kontos
	 */
	public double getUeberziehung() {
		return this.ueberziehung;
	}
	
	/**
	 * Rechnet vom heutigen Datum bis zum Jahresende die Zinsen des Kontos aus, 
	 * aber nur dann wenn der Kontostand positiv ist. Ansonsten sind die Zinsen 0.
	 * Befindet man sich z. B. genau in der Mitte des Jahres (30.6.) 
	 * dann werden zinnsatz/2 Zinsen berechnet
	 * 
	 * Specified by: getZinsen in class Konto
	 * @return die angefallenen Zinsen von heute bis zum Jahresende
	 */
	@Override
	public double getZinsen() {
		double ret = 0.0;
		//Wenn Kontostand kleiner oder gleich 0 ist, sind Zinsen gleich 0
		if (this.kontostand <= 0) {
			ret = 0;
		}
	    else {
	    	//heutiges Datum
	    	Calendar thisDay = Calendar.getInstance();
	    	//Letzter Tag im Jahr
	        Calendar lastDayOfYear = Calendar.getInstance();
	        lastDayOfYear.set(Calendar.MONTH, 11);
	        lastDayOfYear.set(Calendar.DATE, 31);
	        lastDayOfYear.set(Calendar.HOUR_OF_DAY, 23);
	        lastDayOfYear.set(Calendar.MINUTE, 59);
	        lastDayOfYear.set(Calendar.SECOND, 59);
	        //fehlende Tage werden berechnet
	        int daysLeft = lastDayOfYear.get(Calendar.DAY_OF_YEAR) - thisDay.get(Calendar.DAY_OF_YEAR);
	        double divisor = lastDayOfYear.get(Calendar.DAY_OF_YEAR) / daysLeft;
	        //neuer Zinssatz wird berechnet
	        zinssatz = this.zinssatz / divisor;
	        //Zinssatz wird auf Basis vom Kontostand berechnet und zurueckgegeben   
	        ret = this.kontostand * (zinssatz / 100.0);
	        ret = Math.round(ret * 10000.0)/10000.0;
	    }
		return ret;
	}
	
	/**
	 * Ermittelt die Spesen des Gehaltskonto. 
	 * Diese sind 50, wenn das Gehaltskonto einen negativen Kontostand ausweist, ansonsten sind diese 0
	 * Specified by: getSpesen in class Konto
	 * @return die Spesen des Gehaltskontos
	 */
	@Override
	public double getSpesen() {
		double ret = 0.0;
		//Wenn Kontostand negativ ist
		if (this.kontostand < 0) {
			ret = 50;
		}
		return ret;
	}
	
	/**
	 * Bucht unter Ber�cksichtigung des �berziehungsrahmens. 
	 * Wenn eine Buchung den �berziehungsrahmen des Gehaltskontos sprengt, 
	 * wird ein KontoException ausgel�st
	 * Specified by: buchen in class Konto
	 * @param betrag - der zu verbuchende Betrag
	 * @throws KontoException - wenn der �berziehungsrahmen gesprengt wird
	 */
	@Override
	public void buchen(double betrag) throws KontoException {
		if (betrag >= 0) {
			this.kontostand = this.kontostand + betrag;
		}
		else {
			if (this.kontostand + betrag >= this.ueberziehung) {
				this.kontostand = this.kontostand + betrag;
			}
			else {
				throw new KontoException("Diese Buchung �berschreitet den �berziehungsrahmen!");
			}
		}
	}
	
	/**
	 * Ausgabe der Kontodaten. Es wird zus�tzlich noch die eingstellte �berziehung ausgegeben
	 * Overrides: toString in class Konto
	 * @return die Gehaltskontendaten
	 */
	public String toString() {
		return super.toString() + " �berziehung: " + this.getUeberziehung();
	}
}
