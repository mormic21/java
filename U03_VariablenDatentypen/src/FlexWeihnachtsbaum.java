
public class FlexWeihnachtsbaum
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Der flexible Weihnachtsbaum");
		System.out.println("===========================");
		//Der Benutzer gibt einen Integer-Wert für die Variable hoehe ein
		int hoehe = TestScanner.readInt("Geben Sie die Höhe des Baumes ein: ");
		//Der Benutzer gibt einen Integer-Wert für die Variable hoehestamm ein
		int hoehestamm = TestScanner.readInt("Geben sie die Höhe des Stammes ein: ");
		//Ein Absatz wird ausgegeben
		System.out.println();
		//Die Variable anzahlleerzeichen vom Typ Integer soll sein hoehe-1
		int anzahlleerzeichen = hoehe-1;
		//Die Variable anzahlsterne vom Typ Integer soll sein 1
		int anzahlsterne = 1;
		/*
		 * Für die for-schleife wird die Variable j initialisiert. Solange j kleiner gleich 
		 * der Variable hoehe ist, wird der Code innerhalb der Schleife ausgeführt und schlussendlich wird die 
		 * Laufvariable um 1 erhöht
		 */
		for (int j = 1; j <= hoehe; j++) {
			/*
			 *Die Methode printLeerzeichen aus der Klasse Weihnachtsbaum wird aufgerufen und die 
			 *Variable anzahlleerzeichen wird übergeben
			 */
			Weihnachtsbaum.printLeerzeichen(anzahlleerzeichen);
		  //Die Methode printSterne aus der Klasse Weihnachtsbaum wird aufgerufen und die Variable anzahlsterne wird übergeben
			Weihnachtsbaum.printSterne(anzahlsterne);
		  /*
		   * Die Methode printLeerzeichen aus der Klasse Weihnachtsbaum wird aufgerufen und die Variable 
		   * anzahlleerzeichen wird übergeben
		   */
			Weihnachtsbaum.printLeerzeichen(anzahlleerzeichen);
			//Absatz wird ausgegeben
			System.out.println();
			//Die Variable anzahlleerzeichen wird um 1 erniedrigt
			anzahlleerzeichen--;
			//Die Variable anzahlsterne wird um 1 erhöht
			anzahlsterne = anzahlsterne + 2;
		}
		//Die Variable anzahlleerzeichen soll sein hoehe -2
		anzahlleerzeichen = hoehe-2;
		//Die Variable anzahlsterne soll sein 3
		anzahlsterne = 3;
		/*
		 * Für die for-Schleife wird die Laufvariable i mit dem Wert 1 initialisiert. Solange i kleiner als die 
		 * Variable hoehestamm ist, wird der Code in der Schleife ausgeführt. Nach der Ausführung wird die Laufvariable
		 * um 1 erhöht.
		 */
		for (int i = 1; i <= hoehestamm; i++) {
			/*
			 * Die Methode printLeerzeichen aus der Klasse Weihnachtsbaum wird aufgerufen und die 
			 * Variable anzahlleerzeichen wird übergeben
			 */
			Weihnachtsbaum.printLeerzeichen(anzahlleerzeichen);
		  //Die Methode printSterne aus der Klasse Weihnachtsbaum wird aufgerufen und die Variable anzahlsterne wird übergeben
			Weihnachtsbaum.printSterne(anzahlsterne);
			/*
			 * Für die for-Schleife wird die Laufvariable i mit dem Wert 1 initialisiert. Solange i kleiner als die 
		   * Variable hoehestamm ist, wird der Code in der Schleife ausgeführt. Nach der Ausführung wird die Laufvariable
		   * um 1 erhöht.
			 */
			Weihnachtsbaum.printLeerzeichen(anzahlleerzeichen);
			//Absatz wird ausgegeben
			System.out.println();
		}
	}

}
