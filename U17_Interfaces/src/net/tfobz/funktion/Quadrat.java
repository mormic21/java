package net.tfobz.funktion;

/**
 * Klasse Quadrat 
 * implementiert Funktion
 * @author Michael Morandell
 *
 */
public class Quadrat implements Funktion {
	/**
	 * compute
	 * @param x, double
	 * @return double
	 */
	@Override
	public double compute(double x) {
		return x * x;
	}
}