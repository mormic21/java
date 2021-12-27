package net.tfobz.kontoverwaltung;

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
	
	@Override
	public double getZinsen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSpesen() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void setStartueberziehung(double startueberziehung)
            throws KontoException {
		
	}
	
	public static double getStartueberziehung() {
		return 0.0;
	}
	
	public void setUeberziehung(double ueberziehung)
            throws KontoException {
	}
	
	public double getUeberziehung() {
		return 0.0;
	}
	
	@Override
	public void buchen(double betrag) throws KontoException {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return "ok";
	}

}
