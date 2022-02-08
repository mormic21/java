package net.tfobz.ausdrueckeerw;

/**
 * AusdrueckeMain
 * testet die Ausdruecke-Klassen
 * @author Michael Morandell
 *
 */
public class AusdrueckeMain {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//Operartion
		Operation o = 
				new Potenz(
						new Division(
								new Multiplikation(
										new Konstante(3),
										new Potenz(
												new Addition(
														new Konstante(6), 
														new Konstante(7)
												), 
												new Konstante(5)
										)
								),
								new Logarithmus(
										new Argument(10),
										new Wurzel(
												new Argument(2),
												new Addition(
														new Division(
																new Konstante(70), 
																new Konstante(4)
														),
														new Division(
																new Konstante(990), 
																new Konstante(8)
														)
												)
										)
								)
						),
				new Konstante(4)
		);
		//Ergebnis wird ausgegeben
		System.out.println(o.toString());
	}
}