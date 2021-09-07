package net.tfobz.fahrzeuge;

public class Fahrrad extends Fahrzeug {
	protected boolean beleuchtung;
	/**
	 * Fahrrad-Konstruktor, welcher die Geschwindigkeit setz, welche zwischen 0 und 60 sein muss
	 * @param geschwindigkeit
	 */
	public Fahrrad(int geschwindigkeit) {
		super(0);
		if (geschwindigkeit > 0 && geschwindigkeit <= 60) {
			this.setGeschwindigkeit(geschwindigkeit);
		}
	}
	
	/**
	 * setBeleuchtung. Setz die Beleuchtung
	 * @param beleuchtung, die zu setzende beleuchtung, als boolean
	 */
	public void setBeleuchtung(boolean beleuchtung) {
		this.beleuchtung = beleuchtung;
	}
	
	/**
	 * isBeleuchtung. Gibt einen boolean mit dem aktuellen Wert von Beleuchtung zurück
	 * @return beleuchtung, boolean
	 */
	public boolean isBeleuchtung() {
		return this.beleuchtung;
	}
	
	@Override
	/**
	 * toString - gibt die Daten des Objektes als String zurück
	 */
	public String toString() {
		return "Fahrrad G: "+this.getGeschwindigkeit()+", K: "+this.getKilometerstand()+", B: "+this.isBeleuchtung();
	}
	
}
