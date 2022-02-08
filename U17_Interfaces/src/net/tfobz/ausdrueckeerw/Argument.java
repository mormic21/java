package net.tfobz.ausdrueckeerw;

/**
 * Argument
 * erbt von Konstante
 * @author Michael Morandell
 *
 */
public class Argument extends Konstante {
	
	/**
	 * Argument-Konstruktor
	 * @param ergebnis
	 */
	public Argument(double ergebnis) {
		this.setErgebnis(ergebnis);
	}
	
	/**
	 * Argument-Konstruktor
	 */
	public Argument() {
		super();
	}
	
	/**
	 * setErgebnis
	 * @param ergebnis, double
	 */
	@Override
	public void setErgebnis(double ergebnis) {
		double wert = Math.abs(Math.floor(ergebnis));
		if (wert < 1) {
			wert = 1;
		}
		super.setErgebnis(wert);
	}
	
	/**
	 * getErgebnis
	 * @return double
	 */
	public double getErgebnis() {
		return this.ergebnis;
	}
	
	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		return String.valueOf(this.ergebnis);
	}
}