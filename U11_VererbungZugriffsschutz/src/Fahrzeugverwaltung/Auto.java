package Fahrzeugverwaltung;

public class Auto extends Fahrzeug { 
	protected int ps = 0; 
	/**
	 * Auto-Konstruktor, welcher ein Objekt instanziiert und den Wert f�r geschwindigkeit und ps setz.
	 * @param geschwindigkeit, die zu setzende Geschwindigkeit, integer
	 * @param ps, die zu setzenden ps, integer
	 */
	public Auto(int geschwindigkeit, int ps) {
		//Konstruktor der Basisklasse
		super(geschwindigkeit);
		this.setPs(ps);
	}
	
	/**
	 * SetPS. Der �bergebene Parameter muss gr��er 0 sein, ansonsten wird 0 gesetzt
	 * @param ps, integer
	 */
	public void setPs(int ps) { 
		if (ps > 0) {
			this.ps = ps; 
		}
		else {
			this.ps = 0; 
		}
	}
	
	/**
	 * Get-PS, gibt den aktuellen Wert der Variable PS zur�ck
	 * @return ps, als integer
	 */
	public int getPs() { 
		return this.ps; 
	}
	
	@Override
	/**
	 * toString, gibt die Daten als String zur�ck
	 */
	public String toString() {
		return "Auto G: "+this.getGeschwindigkeit()+", K: "+this.getKilometerstand()+", P: "+this.getPs();
	}
}
