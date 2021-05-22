package Fahrzeugverwaltung;

public class Fahrzeug {
	protected int geschwindigkeit = 0;
	protected int kilometerstand = 0;
	
	/**
	 * Custom-Konstruktor. Objekt wird erstellt und Geschwindigkeit wird gesetzt
	 * @param geschwindigkeit, integer
	 */
	public Fahrzeug(int geschwindigkeit) {
		this.setGeschwindigkeit(geschwindigkeit);
	}
	
	/**
	 * SetGeschwindigkeit. Setzt den Wert der Membervariable geschwindigkeit
	 * @param geschwindigkeit, als integer �bergeben
	 */
	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0)
			this.geschwindigkeit = geschwindigkeit;
		else
			this.geschwindigkeit = 0;
	}
	
	/**
	 * GetGeschwindigkeit
	 * gibt den Wert der Membervariable geschwindigkeit zur�ck
	 * @return die Geschwindigkeit, als Integer
	 */
	public int getGeschwindigkeit() {
		return this.geschwindigkeit;
	}
	
	/**
	 * Settermethode, kilometerstand wird nur gesetzt, wenn sie gr��er gleich 0 ist
	 * @param kilometerstand, der zu setzende Kilometerstand als Int
	 */
	public void setKilometerstand(int kilometerstand) {
		if (kilometerstand >= 0) {
			this.kilometerstand = kilometerstand;
		}
	}
	
	/**
	 * GetKilometerstand. Liefert den Wert von kilometerstand zur�ck
	 * @return kilometerstand, als Integer
	 */
	public int getKilometerstand() {
		return this.kilometerstand;
	}
	
	@Override
	/**
	 * toString, gibt die Daten als String zur�ck
	 */
	public String toString() {
		return "Fahrzeug G: "+this.getGeschwindigkeit()+", K: "+this.getKilometerstand();
	}
}
