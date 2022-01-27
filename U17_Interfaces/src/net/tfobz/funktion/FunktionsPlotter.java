package net.tfobz.funktion;

/**
 * Klasse FunktionsPlotter
 * gibt die Werte-Tabellen aus
 * erbt von Object
 * @author Michael Morandell
 *
 */
public class FunktionsPlotter extends Object {
	/**
	 * printTable
	 * @param funktion, Funktion
	 */
	public static void printTable(Funktion funktion) {
		System.out.println("Wertetabelle " + funktion.getClass().getName());
		for (double x = 0.0; x <= 5.0; x += 1)
			System.out.println(x + "->" + funktion.compute(x));
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		printTable(new Wurzel());
		printTable(new Quadrat());
	}
}