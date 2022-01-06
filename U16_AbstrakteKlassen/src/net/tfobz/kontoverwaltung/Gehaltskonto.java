package net.tfobz.kontoverwaltung;

import java.util.Calendar;

/**
 * Die Klasse GehaltsKonto hat zum Unterschied zu einem normalen Konto einen
 * Überziehungsrahmen, welcher beim Buchen nicht unterschritten werden darf. Ein
 * Startüberziehungsrahmen kann für alle anzulegenden Gehaltskonten vorab
 * eingestellt werden. Jedes Gehaltkonto hat einen Überziehungsrahmen der beim
 * Buchen nicht unterschritten werden darf Überziehungsrahmen werden immer als
 * negative Zahlen angegeben Ein Startüberziehungsrahmen kann für alle
 * anzulegenden Gehaltskonten vorab eingestellt werden Gebucht wird auf dem
 * Konto immer unter Berücksichtigung des Überziehungsrahmens. Der Kontostand
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
	//Legt den Startüberziehungsrahmen für alle neu anzulegenden Gehaltskonten fest
	protected static double startueberziehung;
	//Der Überziehungsrahmen des Gehaltskontos
	protected double ueberziehung;
	
	/**
	 * Konstruktor, welcher beim Anlegen des Gehaltskontos den Überziehungsrahmen automatisch vergibt. 
	 * Beim Anlegen des Gehaltskontos wird automatisch der Überziehungsrahmen, 
	 * welcher durch setStartueberziehung gesetzt wurde, für das Gehaltskonto eingestellt
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
	 * Setzt den Startüberziehungsrahmen für alle neu anzulegenden Gehaltskonten
	 * @param startueberziehung - der zu setzen ist
	 * @throws KontoException - falls der Überziehungsrahmen größer als Null ist
	 */
	public static void setStartueberziehung(double startueberziehung)
	        throws KontoException {
		//Wenn Startüberziehung groesser als 0 ist
		if (startueberziehung > 0) {
			throw new KontoException("Startüberziehungsrahmen ist größer als 0 \n Bitte setzten sie einen negativen Wert");
		}
		//Wenn Startüberziehung einen gueltigen Wert hat
		else {
			Gehaltskonto.startueberziehung = startueberziehung;
		}
	}
	
	/**
	 * Gibt den Überziehungsrahmen zurück, der für alle neu zu erstellenden Konten verwendet wird
	 * @return den Startüberziehungsrahmen für alle neu anzulegenden Konten
	 */
	public static double getStartueberziehung() {
		return Gehaltskonto.startueberziehung;
	}
	
	/**
	 * Setzt für das Konto den Überziehungsrahmen. Der Überziehungsrahmen darf nicht positiv sein
	 * @param ueberziehung - darf nicht größer als Null sein
	 * @throws KontoException - falls der einzustellende Überziehungsrahmen größer als Null ist
	 */
	public void setUeberziehung(double ueberziehung)
	        throws KontoException {
		//Wenn Überziehung groesser als 0 ist
		if (ueberziehung > 0) {
			throw new KontoException("Überziehungsrahmen ist größer als Null");
		}
		//Wenn Überziehung einen gueltigen Wert hat
		else {
			this.ueberziehung = ueberziehung;
		}
	}
	
	/**
	 * Liefert den Überziehungsrahmen des Kontos zurück
	 * @return den Überziehungsrahmen des Kontos
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
	 * Bucht unter Berücksichtigung des Überziehungsrahmens. 
	 * Wenn eine Buchung den Überziehungsrahmen des Gehaltskontos sprengt, 
	 * wird ein KontoException ausgelöst
	 * Specified by: buchen in class Konto
	 * @param betrag - der zu verbuchende Betrag
	 * @throws KontoException - wenn der Überziehungsrahmen gesprengt wird
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
				throw new KontoException("Diese Buchung überschreitet den Überziehungsrahmen!");
			}
		}
	}
	
	/**
	 * Ausgabe der Kontodaten. Es wird zusätzlich noch die eingstellte Überziehung ausgegeben
	 * Overrides: toString in class Konto
	 * @return die Gehaltskontendaten
	 */
	public String toString() {
		return super.toString() + " Überziehung: " + this.getUeberziehung();
	}
}
