package net.tfobz.fahrzeuge;

public class Lastwagen extends Auto {
	protected int ladeflaeche = 0;
	/**
	 * Lastwagen-Konstruktor, welcher geschwindigkeit, ps und ladeflaeche setzt
	 * @param geschwindigkeit, die zu setzende Geschwindigkeit, integer
	 * @param ps, die zu setzenden ps, integer
	 * @param ladeflaeche, die zu setzende ladeflaeche, integer
	 */
	public Lastwagen(int geschwindigkeit, int ps, int ladeflaeche) {
		super(geschwindigkeit, ps);
		this.setLadeflaeche(ladeflaeche);
	}
	
	@Override
	/**
	 * setPs. Parameter ps muss min 150 sein, sonst wird 150 gesetzt
	 * @param ps, die zu setzenden Ps, als Integer
	 */
	public void setPs(int ps) {
		if (ps < 150) {
			this.ps = 150;
		}
		else {
			this.ps = ps;
		}
	}
	
	/**
	 * Setz die Ladeflaeche. Sie muss min 0 sein, sonst wird 0 gesetzt
	 * @param ladeflaeche, integer
	 */
	public void setLadeflaeche(int ladeflaeche) {
		if (ladeflaeche > 0) {
			this.ladeflaeche = ladeflaeche;
		}
		else {
			this.ladeflaeche = 0;
		}
	}
	
	/**
	 * Gibt den wert der ladeflaeche zur�ck
	 * @return die ladeflaeche, integer
	 */
	public int getLadeflaeche() {
		return this.ladeflaeche;
	}
	
	@Override
	/**
	 * toString - gibt die Daten des Objektes als String zur�ck
	 */
	public String toString() {
		return "Lastwagen G: "+this.getGeschwindigkeit()+", K: "+this.getKilometerstand()+", P: "+this.getPs()+", L: "+this.getLadeflaeche();
	}
}
