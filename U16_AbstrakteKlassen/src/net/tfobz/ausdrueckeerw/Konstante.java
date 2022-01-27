package net.tfobz.ausdrueckeerw;

/**
 * Konstante
 * erbt von Operand
 * @author Michael Morandell
 *
 */
public class Konstante extends Operand {
	//Membervariable
	protected double ergebnis = 0.0;
	
	/**
	 * Konstante-Konstruktor
	 * @param ergebnis
	 */
	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	/**
	 * Konstante-Konstruktor
	 */
	public Konstante() {
		super();
	}
	
	/**
	 * setErgebnis
	 * @param ergebnis
	 */
	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
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