package net.tfobz.brueche;
/**
 * Testklasse für Bruch.java
 * @author Michael Morandell
 *
 */
public class Testprogramm {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Bruch a = new Bruch(4,332);
			System.out.println("Bruch a: " + a.toString());
			Bruch b = new Bruch(10,7);
			//clonen
			Bruch c = a.clone();
			System.out.println("Bruch b: " + b.toString());
			System.out.println("Bruch c: " + c.toString());
			System.out.println("c eqals to a: " + c.equals(a));
			System.out.println("a equals to c: " + a.equals(c));
			//addieren
			a.addiere(b);
			System.out.println("a + b = " + a.toString());
			a = c.clone();
			//subtrahieren
			a.subtrahiere(b);
			System.out.println("a - b = " + a.toString());
			a = c.clone();
			//multiplizieren
			a.multipliziere(b);
			System.out.println("a * b = " + a.toString());
			a = c.clone();
			//dividieren
			a.dividiere(b);
			System.out.println("a / b = " + a.toString());
		} catch (BruchException e) {
			e.printStackTrace();
		}
		System.out.println("Ende");
	}

}
